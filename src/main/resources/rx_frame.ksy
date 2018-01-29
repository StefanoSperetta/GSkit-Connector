meta:
  id: rx_frame
  endian: le
seq:
  - id: command
    type: u1
  - id: size
    type: u4
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
  - id: rrequency
    type: f8
  - id: datasize
    type: u2
  - id: data
    size: datasize
