# CMR Performance Test
This projects includes a sample application which generates load and sends the executed invocation sequences to the CMR. It is uses to 
test to throughput of the CMR. The sample application and the CMR write the current number of invocation sequences to an influx DB.
This offers the possibility to compute the processing rate of the cmr.

Processing rate: processed invocation sequences / sent invocation sequences

The modified CMR is available here: 
https://github.com/mariusoe/inspectIT/tree/cmr-load-test
