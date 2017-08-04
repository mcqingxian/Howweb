package com.hoau.how.module.obh.shared.util;



/**
 * 
* <p>Title: Verhoeff</p>
* <p>Description:条码检验码生成类 </p>
* <p>Company: HOAU</p> 
* @author lanhong zhang
* @date 2015年6月28日
 */
public class Verhoeff
{
       // The multiplication table
       static int[][] d  = new int[][]
       {
           {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
           {1, 2, 3, 4, 0, 6, 7, 8, 9, 5},
           {2, 3, 4, 0, 1, 7, 8, 9, 5, 6},
           {3, 4, 0, 1, 2, 8, 9, 5, 6, 7},
           {4, 0, 1, 2, 3, 9, 5, 6, 7, 8},
           {5, 9, 8, 7, 6, 0, 4, 3, 2, 1},
           {6, 5, 9, 8, 7, 1, 0, 4, 3, 2},
           {7, 6, 5, 9, 8, 2, 1, 0, 4, 3},
           {8, 7, 6, 5, 9, 3, 2, 1, 0, 4},
           {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
       };

       // The permutation table
       static int[][] p = new int[][]
       {
           {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
           {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
           {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
           {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
           {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
           {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
           {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
           {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
       };

       // The inverse table
       static int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};


       /*
        * For a given number generates a Verhoeff digit
        *
        */
      public static String generateVerhoeff(String num){

         int c = 0;
         int[] myArray = StringToReversedIntArray(num);

         for(int i = 0; i < myArray.length; i++)
         {
            c = d[c][p[((i + 1) % 8)] [myArray[i]]];
         }

         return Integer.toString(inv[c]);
      }


      /*
       * Validates that an entered number is Verhoeff compliant.
       * NB: Make sure the check digit is the last one.
       */
      public static boolean validateVerhoeff(String num){

              int c = 0;
              int[] myArray = StringToReversedIntArray(num);

              for (int i = 0; i < myArray.length; i++)
              {
                 c = d[c][p[(i % 8)][myArray[i]]];
              }

         return (c == 0);
      }



      /*
       * Converts a string to a reversed integer array.
       */
      private static int[] StringToReversedIntArray(String num){

         int[] myArray = new int[num.length()];
         char[] nums = num.toCharArray();
         for (int i = 0; i < nums.length; i++) {
        	 if (Character.isDigit(nums[i])) {
        		 myArray[i] = Integer.valueOf(nums[i] + "");
        	 } else {
        		 myArray[i] = 0;
        	 }
         }

         myArray = Reverse(myArray);

         return myArray;

      }

      /*
       * Reverses an int array
       */
      private static int[] Reverse(int[] myArray)
      {
         int[] reversed = new int[myArray.length];

         for(int i = 0; i < myArray.length ; i++)
         {
            reversed[i] = myArray[myArray.length - (i + 1)];
         }

         return reversed;
      }
      public static void main(String[] args) {
    	  
      Integer num = 100;
    	  for(Integer i=1;i<=num;i++){
				 String temp=null;
		/*	  if(i.SIZE<10){
				 temp="000"+i; 	
			  }else if(i.SIZE<100){
				  temp="00"+i;
			  }else if(i.SIZE<1000){
				  temp="0"+i;
			  }else {
				  temp=i+"";
			  }*/
				if(i/1000 != 0){
					temp=i+"";
				}else if(i/100 != 0){
					temp = "0"+i;
				}else if(i/10 != 0){
					temp ="00" + i;
				}else{
					temp ="000"+i;
				}
			  System.out.println(temp+"----"+"第"+i+"次");
	}
      }
	}