// Aritra Sarkar : 04-09-2017

/*
	Start	char array[INF] = {0};	char *ptr = array;
	>		++ptr;
	<		--ptr;
	+		++*ptr;
	-		--*ptr;
	.		putchar(*ptr);
	,		*ptr = getchar();
	[		while(*ptr) {
	]		}
*/

/*
	   2 3 4 5 6 7       30 40 50 60 70 80 90 100 110 120
     -------------      ---------------------------------
    0:   0 @ P ` p     0:    (  2  <  F  P  Z  d   n   x
    1: ! 1 A Q a q     1:    )  3  =  G  Q  [  e   o   y
    2: " 2 B R b r     2:    *  4  >  H  R  \  f   p   z
    3: # 3 C S c s     3: !  +  5  ?  I  S  ]  g   q   {
    4: $ 4 D T d t     4: "  ,  6  @  J  T  ^  h   r   |
    5: % 5 E U e u     5: #  -  7  A  K  U  _  i   s   }
    6: & 6 F V f v     6: $  .  8  B  L  V  `  j   t   ~
    7: ´ 7 G W g w     7: %  /  9  C  M  W  a  k   u  DEL
    8: ( 8 H X h x     8: &  0  :  D  N  X  b  l   v
    9: ) 9 I Y i y     9: ´  1  ;  E  O  Y  c  m   w
    A: * : J Z j z
    B: + ; K [ k {
    C: , < L \ l |
    D: - = M ] m }
    E: . > N ^ n ~
    F: / ? O _ o DEL
*/

/*
 	>		62
	<		60
	+		43
	-		45
	.		46
	,		44
	[		91
	]		93
*/

/*
	Enter code : ,>,<[->.+<]
	Input:26
	Input:65
	ABCDEFGHIJKLMNOPQRSTUVWXYZ
*/

import java.io.*;
class bf
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter code : ");
		String prog = br.readLine();
		int tape[] = new int[1000];
		int head = 500;
		int i, b, m;
		for (i = 0; i < tape.length; i++)
			tape[i] = 0;
		int ip = 0;
		while (ip >= 0 && ip < prog.length()) {
			if (prog.charAt(ip) == '.') {
				System.out.print((char)tape[head]);
				ip++;
			}
			else if (prog.charAt(ip) == ',') {
				System.out.print("Input:");
				tape[head] = Integer.parseInt(br.readLine());
				ip++;
			}
			else if (prog.charAt(ip) == '>') {
				++head;
				ip++;
			}
			else if (prog.charAt(ip) == '<') {
				--head;
				ip++;
			}
			else if (prog.charAt(ip) == '+') {
				++tape[head];
				ip++;
			}
			else if (prog.charAt(ip) == '-') {
				--tape[head];
				ip++;
			}
			else if (prog.charAt(ip) == '[') {
				if (tape[head] == 0) {
					for (b = ip+1, m = 0; b < prog.length(); b++) {
						if (prog.charAt(b) == ']' && m == 0)
							break;
						else if (prog.charAt(b) == '[')
							m++;
						else if (prog.charAt(b) == ']')
							m--;
					}
					ip = b+1;
				}
				else
					ip++;
			}
			else if (prog.charAt(ip) == ']') {
				for (b = ip-1, m = 0; b >= 0; b--) {
					if (prog.charAt(b) == '[' && m == 0)
						break;
					else if (prog.charAt(b) == '[')
						m++;
					else if (prog.charAt(b) == ']')
						m--;
				}
				ip = b;
			}
		}
		System.out.println();
	}
}
