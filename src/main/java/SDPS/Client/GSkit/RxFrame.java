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

package SDPS.Client.GSkit;

//This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class RxFrame extends KaitaiStruct {
 public static RxFrame fromFile(String fileName) throws IOException {
     return new RxFrame(new KaitaiStream(fileName));
 }

 public RxFrame(KaitaiStream _io) {
     super(_io);
     this._root = this;
     _read();
 }

 public RxFrame(KaitaiStream _io, KaitaiStruct _parent) {
     super(_io);
     this._parent = _parent;
     this._root = this;
     _read();
 }

 public RxFrame(KaitaiStream _io, KaitaiStruct _parent, RxFrame _root) {
     super(_io);
     this._parent = _parent;
     this._root = _root;
     _read();
 }
 private void _read() {
     this.datarate = this._io.readU4le();
     this.modulationsize = this._io.readU1();
     this.modulation = new String(this._io.readBytes(modulationsize()), Charset.forName("UTF-8"));
     this.rssi = this._io.readF8le();
     this.frequency = this._io.readF8le();
     this.datasize = this._io.readU2le();
     this.data = this._io.readBytes(datasize());
     this.timestamp = this._io.readU4le();
 }
 private long datarate;
 private int modulationsize;
 private String modulation;
 private double rssi;
 private double frequency;
 private int datasize;
 private byte[] data;
 private long timestamp;
 private RxFrame _root;
 private KaitaiStruct _parent;
 public long datarate() { return datarate; }
 public int modulationsize() { return modulationsize; }
 public String modulation() { return modulation; }
 public double rssi() { return rssi; }
 public double frequency() { return frequency; }
 public int datasize() { return datasize; }
 public byte[] data() { return data; }
 public long timestamp() { return timestamp; }
 public RxFrame _root() { return _root; }
 public KaitaiStruct _parent() { return _parent; }
}