meta:
  id: rx_frame
  endian: le
seq:
  - id: datarate
    type: u4
  - id: modulationsize
    type: u1
  - id: modulation
    type: str
    size: modulationsize
    encoding: UTF-8
  - id: rssi
    type: f8
  - id: frequency
    type: f8
  - id: datasize
    type: u2
  - id: data
    size: datasize
  - id: timestamp
    type: u4
