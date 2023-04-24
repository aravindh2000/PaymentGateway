/*
@author: Mel28vin
date:18-04-2023

ECE Association level-1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class LevelOne {
  public static void main(String[] args) {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      String inp = fs.next();
      int len = inp.length();
      ArrayList<String> matrix = new ArrayList<>(len);
      for (int i = 0; i < len; ++i) {
        String shift = inp.substring(i) + inp.substring(0, i);
        matrix.add(shift);
      }

      int maxArea = 0;
      int[] heights = new int[len];
      for (int i = 0; i < len; ++i) {
        for (int j = 0; j < len; ++j) {
          if (matrix.get(i).charAt(j) == '1') {
            ++heights[j];
          } else {
            heights[j] = 0;
          }
        }
        int area = largestRectangleArea(heights);
        maxArea = Math.max(area, maxArea);
      }

      System.out.println(maxArea);
    }
  }

  static int largestRectangleArea(int histo[]) {
    Stack<Integer> st = new Stack<>();
    int maxA = 0;
    int n = histo.length;
    for (int i = 0; i <= n; i++) {
      while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
        int height = histo[st.peek()];
        st.pop();
        int width;
        if (st.empty()) width = i;
        else width = i - st.peek() - 1;
        maxA = Math.max(maxA, width * height);
      }
      st.push(i);
    }
    return maxA;
  }

  static class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    public String next() {
      while (!st.hasMoreElements())
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    int[] readArray(int n) {
      int[] a = new int[n];
      for (int i = 0; i < n; i++) a[i] = nextInt();
      return a;
    }

    long[] readLongArray(int n) {
      long[] a = new long[n];
      for (int i = 0; i < n; i++) a[i] = nextLong();
      return a;
    }

    long nextLong() {
      return Long.parseLong(next());
    }
  }
}
