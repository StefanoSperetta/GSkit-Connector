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

public class GSkitInterface 
{
	/*
	 *  private final int PACKET_ID = 85;
    byte[] tmp = packet.getPacket();
    int pktsize = 36 + modulation.length() + tmp.length;

ByteArrayOutputStream dd = new ByteArrayOutputStream(pktsize);
myDataOutputStream dos = new myDataOutputStream(dd, myDataOutputStream.LITTLE_ENDIAN);

// sending frame command
    dos.writeByte(PACKET_ID);
    
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
    dos.writeShort(tmp.length);
    dos.write(tmp);
    
    // timestamp
    dos.writeLong(timestamp);

return dd.toByteArray();
*/
}
