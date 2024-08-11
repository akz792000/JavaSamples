package com.hacker.rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
EUR/USD rate of 1.1003 means that for 1 EUR we might receive 1.1003 USD.

USD/CAD rate of 1.3174 means that for 1 USD we might receive 1.3174 CAD.

We might perform a pair of exchanges, i.e., convert EUR to USD and then convert USD to CAD.
That is equivalent to the conversion of EUR to CAD at the rate of EUR/USD * USD/CAD = 1.1003 * 1.3174 = 1.4495_3522.
So when we have EUR/USD = 1.1003 and USD/CAD = 1.3174, we might consider that the EUR/CAD cross rate is equal to 1.4495_3522, i.e.,
we might perform currency conversion and for 1 EUR receive 1.4495 CAD.

Given a sequence of rates for N timestamps for two underlying currency pairs, you need to determine time when the cross rate is at its maximum.
If a data set contains several maximums, then output the last one.

On input your program receives:

currency pair, whose maximum rate is required to find
count of rows with corresponding underlying rates,
underlying rates that are represented as following rows:
timestamp ccypair rate

Constraints

0 ≤ timestamp ≤ 106
2 ≤ count ≤ 106
0.0001 ≤ rate1,…,rateN ≤ 1000.0000
Example 1
Input

EUR/RON
8
1 EUR/USD 1.1003
1 USD/RON 4.5111
1 USD/GBP 0.7859
2 EUR/USD 1.1002
2 USD/RON 4.5111
2 USD/GBP 0.786
3 USD/RON 4.5111
3 EUR/USD 1.1003
3 USD/GBP 0.7859
4 USD/GBP 0.7858
4 EUR/USD 1.1002
4 USD/RON 4.5111

Result: 3

Explanation: 1 EUR/USD * 1 USD/RON = 4.96356333;
             2 EUR/USD * 2 USD/RON = 4.96311222;
             3 USD/RON * 3 EUR/USD = 4.96356333;
             4 EUR/USD * 4 USD/RON = 4.96311222;
             max of (crossrate_1; crossrate_2; crossrate_3; crossrate_4) = 4.96356333

Example 2
Input

EUR/CAD
8
1001 EUR/USD 1.1003
1001 USD/CAD 1.3176
1002 USD/CAD 1.3175
1002 EUR/USD 1.1004
1004 EUR/USD 1.1005
1004 USD/CAD 1.3172
1005 EUR/USD 1.1004
1005 USD/CAD 1.3176
Result: 1005

Example 3
Input

EUR/USD
8
101 EUR/GBP 0.8569
101 GBP/USD 1.2840
102 EUR/GBP 0.8569
102 GBP/USD 1.2839
103 EUR/GBP 0.857
103 GBP/USD 1.2840
104 EUR/GBP 0.8571
104 GBP/USD 1.2841
Returns: 104
 */

public class Exchange {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String targetCurrencyPair = br.readLine();
    String currency0 = targetCurrencyPair.split("/")[0];
    String currency1  = targetCurrencyPair.split("/")[1];
    int count = Integer.parseInt(br.readLine());

    Map<String, String> currencyPairMap = new HashMap<>();
    Map<String, Double> currencyRateMap = new HashMap<>();
    double maxCrossRate = -1;
    int maxTimestamp = -1;
    int oldstamp = -1;
    int timestamp = -1;

    for (int i = 0; i < count; i++) {
      String[] input = br.readLine().split(" ");
      timestamp = Integer.parseInt(input[0]);
      String currencyPair = input[1];
      String currencyPair0 = currencyPair.split("/")[0];
      String currencyPair1 = currencyPair.split("/")[1];
      Double currencyRate = Double.parseDouble(input[2]);

      if (oldstamp != timestamp && oldstamp != -1) {

        String c0 = currencyPairMap.get(currency0);
        if (c0 != null) {
          String c1 = currencyPairMap.get(c0);
          if (c1 != null && c1.equals(currency1)) {
            Double tmp = currencyRateMap.get(currency0 + "/" + c0) * currencyRateMap.get(c0 + "/" + currency1);
            if (maxCrossRate < tmp) {
              maxCrossRate = tmp;
              maxTimestamp = timestamp;
            }
          }
        }

        currencyPairMap = new HashMap<>();
        currencyRateMap = new HashMap<>();
      }
      oldstamp = timestamp;


      currencyPairMap.put(currencyPair0, currencyPair1);
      currencyRateMap.put(currencyPair, currencyRate);

      if (currencyPair.equals(targetCurrencyPair)) {
        if (maxCrossRate < currencyRate) {
          maxCrossRate = currencyRate;
          maxTimestamp = timestamp;
        }
      }

    }

    String c0 = currencyPairMap.get(currency0);
    if (c0 != null) {
      String c1 = currencyPairMap.get(c0);
      if (c1 != null && c1.equals(currency1)) {
        Double tmp = currencyRateMap.get(currency0 + "/" + c0) * currencyRateMap.get(c0 + "/" + currency1);
        if (maxCrossRate < tmp) {
          maxTimestamp = timestamp;
        }
      }
    }

    System.out.println(maxTimestamp);
  }
}
