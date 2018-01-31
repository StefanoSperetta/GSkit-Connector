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

import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.Charset;

public class TransferFrame extends KaitaiStruct {
    public static TransferFrame fromFile(String fileName) throws IOException {
        return new TransferFrame(new KaitaiStream(fileName));
    }

    public TransferFrame(KaitaiStream _io) {
        super(_io);
        this._root = this;
        _read();
    }

    public TransferFrame(KaitaiStream _io, KaitaiStruct _parent) {
        super(_io);
        this._parent = _parent;
        this._root = this;
        _read();
    }

    public TransferFrame(KaitaiStream _io, KaitaiStruct _parent, TransferFrame _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root;
        _read();
    }
    private void _read() {
        this.command = this._io.readU1();
        this.size = this._io.readU4le();
    }
    private int command;
    private long size;
    private TransferFrame _root;
    private KaitaiStruct _parent;
    public int command() { return command; }
    public long size() { return size; }
    public TransferFrame _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}