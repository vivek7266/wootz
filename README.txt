Wootz Compiler

Software requirements:

ANTLR v4
Apache Maven 3.5.4
Java version >= 8 (this project also runs on java 10.0.2 )

Running instructions:

In the home directory: wootz
this should be the working directory for following command to work.

$ mvn clean install
$ java -jar target/wootz-1.0-SNAPSHOT.jar <path_of_prototxt> <multiplexing_boolean>


For example:

===================================================================================================

1. To run inception_v1.prototxt without multiplexing

$ mvn clean install
$ java -jar target/wootz-1.0-SNAPSHOT.jar src/main/resources/inception_v1.prototxt
Saved file in location: inception_v1.py

===================================================================================================

2. To run inception_v1.prototxt with multiplexing

$ mvn clean install
$ java -jar target/wootz-1.0-SNAPSHOT.jar src/main/resources/inception_v1.prototxt true
Saved file in location: inception_v1-multiplex.py

===================================================================================================

3. To run resnet50.prototxt with multiplexing

$ mvn clean install
$ java -jar target/wootz-1.0-SNAPSHOT.jar src/main/resources/resnet50.prototxt
Saved file in location: resnet50.py

===================================================================================================

4. To run alexnet.prototxt with multiplexing

$ mvn clean install
$ java -jar target/wootz-1.0-SNAPSHOT.jar src/main/resources/alexnet.prototxt
Saved file in location: alexnet.py

===================================================================================================


Grammar: src/main/java/grammars/CaffePrototxt.g4
ANTLR generated files: src/main/java/generators
Test cases: src/main/resources/*.prototxt
output: *.py
Main class: src/main/java/wootz/WootzMain.java