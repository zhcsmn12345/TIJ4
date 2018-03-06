34: 1: //: io/E12_LineNumber.java
33: 2: // {Args: E12_LineNumber.java E12_LineNumber.out}
32: 3: /****************** Exercise 12 *****************
31: 4:  * Modify Exercise 8 to also open a text file so
30: 5:  * you can write text into it. Write the lines in the
29: 6:  * LinkedList, along with line numbers (do not
28: 7:  * attempt to use the "LineNumber" classes), out
27: 8:  * to the file.
26: 9:  ***********************************************/
25: 10: package io;
24: 11: import java.io.*;
23: 12: import java.util.*;
22: 13: 
21: 14: public class E12_LineNumber {
20: 15:   public static void main(String[] args)
19: 16:   throws java.io.IOException {
18: 17:     if(args.length != 2) {
17: 18:       System.err.println(
16: 19:         "Usage: java E12_LineNumber infile outfile");
15: 20:       return;
14: 21:     }
13: 22:     List<String> list = E07_FileIntoList.read(args[0]);
12: 23:     PrintWriter out =
11: 24:       new PrintWriter(
10: 25:         new BufferedWriter(
9: 26:           new FileWriter(args[1])));
8: 27:     // We need to count backwards...
7: 28:     int line = list.size();
6: 29:     for(ListIterator<String> it =
5: 30:         list.listIterator(list.size()); it.hasPrevious();)
4: 31:       out.println(line-- + ": " + it.previous());
3: 32:     out.close();
2: 33:   }
1: 34: } ///:~
