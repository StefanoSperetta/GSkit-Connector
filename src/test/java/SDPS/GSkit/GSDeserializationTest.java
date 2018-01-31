/*
 *  SDTL: A data transfer layer to transfer data between a ground station and a data archive.
 *  Copyright (C) 2017  Stefano Speretta - Delft University of Technology
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package SDPS.GSkit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import SDPS.Client.GSkit.RxFrame;
import SDPS.Client.GSkit.TransferFrame;
import io.kaitai.struct.KaitaiStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the de-serialization of data coming from GSkit
 */
public class GSDeserializationTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GSDeserializationTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GSDeserializationTest.class );
    }

    /**
     * Test 
     * @throws IOException 
     */
    public void testSerialization() throws IOException
    {
    		Random rnd = new Random();
    		byte[] data = new byte[50];
    		
    		rnd.nextBytes(data);
        String modulation = "AAA";
        byte packetID = 0x55;
        int datarate = 1200;
        double RSSI = 1.3;
        double frequency = 145.678;
        long timestamp = 1000000;
        
        int pktsize = 36 + modulation.length() + data.length;

        ByteArrayOutputStream dd = new ByteArrayOutputStream(pktsize);
        FlexibleDataOutputStream dos = new FlexibleDataOutputStream(dd, false);

        // sending frame command
        dos.writeByte(packetID);
        
        // sending packet size
        dos.writeInt(pktsize);
        
        // datarate
        dos.writeInt(datarate);
        
        // modulation
        dos.writeByte(modulation.length());
        dos.writeBytes(modulation);
        
        // RSSI
        dos.writeDouble(RSSI);
        
        // frequency
        dos.writeDouble(frequency);
        
        // packet payload
        dos.writeShort(data.length);
        dos.write(data);
        
        // timestamp
        dos.writeLong(timestamp);

        byte[] frame = dd.toByteArray();
        	byte[] transfer = Arrays.copyOf(frame, 5);

    		KaitaiStream ks = new KaitaiStream(transfer);
    		TransferFrame tf = new TransferFrame(ks);
    		int parsedCommand = tf.command();
    		long parsedSize = tf.size();
    		
    		System.out.println("parsedCommand " + parsedCommand);
    		System.out.println("parsedSize " + parsedSize);
    		
    		byte[] rxsubframe = Arrays.copyOfRange(frame, 5, 5 + (int)parsedSize);
    		RxFrame rxf = new RxFrame(new KaitaiStream(rxsubframe));
    		System.out.println(rxf.datarate());
    		System.out.println(rxf.modulationsize());
    		System.out.println(rxf.modulation());
    		System.out.println(rxf.rssi());
    		System.out.println(rxf.frequency());
    		System.out.println(rxf.datasize());
    		System.out.println(Arrays.toString(rxf.data()));
    }
}
