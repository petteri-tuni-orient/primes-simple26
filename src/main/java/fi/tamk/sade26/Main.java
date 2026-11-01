package fi.tamk.sade26;

import java.util.Calendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void main(String[] args) {
        var max = 30201;
        if (args.length >0) {
            max = Integer.valueOf(args[0]);
        }
        IO.println("Heading to " +  max);

        int totalTrack = 50;
        var reportPoint = max / totalTrack;
        int trackCnt = 0;

        long startTime = curTime();


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        var primeCount = 0;
        int i;
        boolean trackReport = true;


        for (i = 2; i <= max; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            //IO.println("i = " + i);

            if ( (i % reportPoint) == 0) {
                trackReport = true;
            }

            if(testPrime(i)) {
                if (trackReport) {
                    trackCnt++;

                    long curMoment = curTime();
                    long diff = curMoment - startTime;

                    IO.println(trackCnt + ") " + i + "( " + primeCount + ") --> " + diff);
                    trackReport = false;

                }
                primeCount++;
            }

        }

        IO.println("\nElapsed: " + (curTime() - startTime));

        IO.println("Total " + i + " - primes " + primeCount);
    }

    private static boolean testPrime(int candidate) {
        for (int k=2; k < (candidate-1); k++ ) {
            Double resultDouble = (double) candidate / (double)k;
            Integer resultInt = candidate / k;

            if (resultDouble.equals(resultInt.doubleValue())) {
                // IO.println("Found: " + k);
                return false;
            }

        }
        return true;
    }

    private static long curTime () {
        // Get current time in milliseconds
        return Calendar
                .getInstance()
                .getTimeInMillis();

    }
}
