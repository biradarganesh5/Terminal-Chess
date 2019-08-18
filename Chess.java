import java.util.Scanner;


class playerDetails
{
	String player2,player1;
	public void name()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Player 1 name - "); 
		player1 = input.nextLine();
		System.out.println("Player 2 name - ");
		player2 = input.nextLine();
	}
	playerDetails()
	{
		player1 = "PLAYER 1";
		player2 = "PLAYER 2";
	}

	public void display()
	{
		System.out.println("P1-"+player1+"\tP2-"+player2);
	}
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



class Chess
{
	
					
	public static void main(String[] args)
	{
		
		int choice,evenP1_oddP2=2,check,e=0,f=0;
		board b = new board();
		availability av = new availability();
		Scanner s = new Scanner(System.in);
		System.out.println("\t\t\t\t\t\t***********WELCOME TO CHESS*************\n");
		System.out.println("\t\t\t\t\t\t\t\t1.New game\n\t\t\t\t\t\t\t\t2.Exit \n");
		Scanner input = new Scanner(System.in);
//		choice = s.nextInt();
		playerDetails pd = new playerDetails();
//		while(e!=1)				
			b.draw();
			while(f!=1)
			{
				System.out.print("\n\n"+b.chance_selector(evenP1_oddP2%2)+" Select a pawn coordinate -");
				String xy = s.nextLine();
				String strArray[] = xy.toLowerCase().split("");
				int x = av.assign(strArray[0]);
				int y = av.assign(strArray[1]);
				if(evenP1_oddP2 % 2 == 0)
				{
					check = av.check_availability(x,y); 
					if(check==1)
					{
						System.out.print("\n\nMove to-");
						String xyz = s.nextLine();
						String strArray1[] = xyz.toLowerCase().split("");
						int x1 = av.assign(strArray1[0]);
						int y1 = av.assign(strArray1[1]);
						b.move_check_player1(x,y,x1,y1);
						if(b.a[x][y]==0)
						{
							evenP1_oddP2++;
							continue;
						}
						else
						{
							continue;
						}
					}
					else if(check==0)
					{
						System.out.println("\n\nXXXXXXXXXXXXXXXXXXXXXXX Invalid pawn choice XXXXXXXXXXXXXXXXXXXX\n\n");
						continue;
					}

					else if(check == -1)
					{
						System.out.println("\n\nXXXXXXXXXXXXXX Choose your own pawn dude XXXXXXXXXXXXXXX\n\n");
						continue;
					}
				}
				else if(evenP1_oddP2 % 2 == 1)
				{
					check = av.check_availability(x,y);                     
					if(check==-1)
					{
						System.out.print("\n\nMove to-");
						String xyz = s.nextLine();
						String strArray1[] = xyz.toLowerCase().split("");
						int x1 = av.assign(strArray1[0]);
						int y1 = av.assign(strArray1[1]);
						b.move_check_player2(x,y,x1,y1);
						if(b.a[x][y]==0)
						{
							evenP1_oddP2++;
							continue;
						}
						else
						{
							continue;
						}
					}
					else if(check==0)
					{
						System.out.println("\n\nXXXXXXXXXXXXXXXXXXXXXXX Invalid pawn choice XXXXXXXXXXXXXXXXXXXX\n\n");
						continue;
					}
					else if(check == 1)
					{
						System.out.println("\n\nXXXXXXXXXXXXXX Choose your own pawn dude XXXXXXXXXXXXXX\n\n");
						continue;
					}
				}
				else
				{
					System.out.println("\nsome error\n");
				}
		
//		switch(choice)
//		{
//		case 1:
//				
//		}
		
	}

}
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class board 
{

	static int[][] a = {
					 	 {1,2,3,4,5,3,2,1},
					 	 {9,9,9,9,9,9,9,9},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
					 	 {0,0,0,0,0,0,0,0},
					 	 {90,90,90,90,90,90,90,90},
					 	 {10,20,30,40,50,30,20,10}
						};
	layout l = new layout();
	
	public void draw()
	{

		int i,j;
		char k='A';
		System.out.println("           A                B               C              D               E               F                G               H");
		
		for(i=0;i<8;i++)
		{
			System.out.println("    ________________________________________________________________________________________________________________________________");
			System.out.println();
			System.out.print(" "+k+"  ");
			k++;
			for(j=0;j<8;j++)
			{
				if(a[i][j]==1)
					System.out.print(l.elephant(1));
				else if(a[i][j]==2)
					System.out.print(l.horse(1));
				else if(a[i][j]==3)
					System.out.print(l.camel(1));
				else if(a[i][j]==4)
					System.out.print(l.queen(1));
				else if(a[i][j]==5)
					System.out.print(l.king(1));
				else if(a[i][j]==9)
					System.out.print(l.slave(1));
				else if(a[i][j]==0)
					System.out.print("|              |");
				else if(a[i][j]==10)
					System.out.print(l.elephant(2));
				else if(a[i][j]==20)
					System.out.print(l.horse(2));
				else if(a[i][j]==30)
					System.out.print(l.camel(2));
				else if(a[i][j]==40)
					System.out.print(l.queen(2));
				else if(a[i][j]==50)
					System.out.print(l.king(2));
				else if(a[i][j]==90)
					System.out.print(l.slave(2));	
			}
			System.out.println();
			System.out.println("    ________________________________________________________________________________________________________________________________");	
		}
	}

	public String chance_selector(int x)
	{
		if(x==0)
		{
			return "Player 1";
		}
		else if(x==1)
		{
			return "Player 2";
		}
		else
		{
			return "error";
		}
	} 

	public void move_check_player1(int x,int y,int x1,int y1)
	{
		availability av = new availability();
		if(a[x][y]==1)                                                         																	
		{
			if(y==y1||x==x1)																	
			{
				int check = av.check_availability(x1,y1);
				if(check == 1)																												
				{
					System.out.println("\n"+av.selfOccupied()+"\n");
				  	
				}

				else if(check == 0||check==-1)
				{
					if(x==x1)
					{
						if(y>y1)
						{
							for(int u=y-1;u>=y1;u--)
							{
								int print = av.check_availability(x,u);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y<u)
								{
									continue;
								}
								else if(print == -1 && y1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}

						else
						{
							for(int u=y+1;u<=y1;u++)
							{
								int print = av.check_availability(x,u);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y>u)
								{
									continue;
								}
								else if(print == -1 && y1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}

					else if(y==y1)
					{
						if(x>x1)
						{
							for(int u=x-1;u>=x1;u--)
							{
								int print = av.check_availability(u,y);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x<u)
								{
									continue;
								}
								else if(print == -1 && x1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
						else
						{
							for(int u=x+1;u<=x1;u++)
							{
								int print = av.check_availability(u,y);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x>u)
								{
									continue;
								}
								else if(print == -1 && x1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}
					
				}
			}
			else
			{ 
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==2)                                                    																		   
		{
			int check = av.check_availability(x1,y1);
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(x1==x-2&&y1==y+1&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x-2&&y1==y-1&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x-1&&y1==y+2&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x-1&&y1==y-2&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}



			else if(x1==x+2&&y1==y+1&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x+2&&y1==y-1&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x+1&&y1==y+2&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x+1&&y1==y-2&&(check==0||check==-1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else
			{ 
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==3)                                                  																		     
		{
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(x==x1 || y==y1)
			{
				System.out.println("\n"+av.invalid()+"\n");
			}
			else if(x1>x&&y1<y)
			{
				if(x1-x==y-y1)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
				
			}

			else if(x1<x&&y1>y)
			{
				if(x-x1==y1-y)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1<x&&y1<y)
			{
				if(x-x1==y-y1)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1>x&&y1>y)
			{
				if(x1-x==y1-y)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==4)                                                 																				      
		{
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(x1>x&&y1<y)
			{
				if(x1-x==y-y1)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
				
			}

			else if(x1<x&&y1>y)
			{
				if(x-x1==y1-y)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1<x&&y1<y)
			{
				if(x-x1==y-y1)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1>x&&y1>y)
			{
				if(x1-x==y1-y)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == 1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == -1)
						{
							if(e==x1 && f==y1 && print1 == -1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
			else if(y==y1||x==x1)																	
			{
				int check = av.check_availability(x1,y1);
				if(check == 1)																												
				{
					System.out.println("\n"+av.selfOccupied()+"\n");
				  	
				}

				else if(check == 0||check==-1)
				{
					if(x==x1)
					{
						if(y>y1)
						{
							for(int u=y-1;u>=y1;u--)
							{
								int print = av.check_availability(x,u);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y<u)
								{
									continue;
								}
								else if(print == -1 && y1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}

						else
						{
							for(int u=y+1;u<=y1;u++)
							{
								int print = av.check_availability(x,u);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y>u)
								{
									continue;
								}
								else if(print == -1 && y1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}

					else if(y==y1)
					{
						if(x>x1)
						{
							for(int u=x-1;u>=x1;u--)
							{
								int print = av.check_availability(u,y);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x<u)
								{
									continue;
								}
								else if(print == -1 && x1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
						else
						{
							for(int u=x+1;u<=x1;u++)
							{
								int print = av.check_availability(u,y);
								if(print == 1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == -1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x>u)
								{
									continue;
								}
								else if(print == -1 && x1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}
					
				}
			}
			else
			{ 
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==5)                   //KING                               																			       
		{
			int check = av.check_availability(x1,y1);
			if(x==x1&&y==y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(check == 1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(check == -1 || check == 0)
			{
				if(x==x1)
				{
					if(y1==y+1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
   						draw();
   						
   					}
					else if(y1==y-1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
						
					}
					else
					{
						System.out.println("\n"+av.invalid()+"\n");
					}
				}
				else if(y==y1)
				{
					if(x1==x+1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
						
					}
					else if(x1==x-1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
						
					}
					else
					{
						System.out.println("\n"+av.invalid()+"\n");
					}
				}
				else if(x1==x+1 && y1==y+1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
					
				}
				else if(x1==x-1 && y1==y-1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
									
				}
				else if(x1==x+1 && y1==y-1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
									
				}
				else if(x1==x-1 && y1==y+1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
									
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==9)
		{
			int mo=x1-x;
			int check = av.check_availability(x1,y1);
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(y==y1)
			{
				if((x==1&&y==0)||(x==1&&y==1)||(x==1&&y==2)||(x==1&&y==3)||(x==1&&y==4)||(x==1&&y==5)||(x==1&&y==6)||(x==1&&y==7))
				{
					if(x1==x+2)
					{
						if(check==0&&a[x+1][y]==0)
						{
							a[x1][y1] = a[x][y];
							a[x][y] = 0;
							draw();
						}
						else
						{
							System.out.println("\n"+av.invalid()+"\n");
						}
					}
					else if(x1==x+1&&check==0)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
					}
					else
					{
						System.out.println("\n"+av.invalid()+"\n");
					}
				}
				else if(x1==x+1&&check==0)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
			else if(x1==x+1&&y1==y-1&&check==-1)
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x+1&&y1==y+1&&check==-1)
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else
			{
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void move_check_player2(int x,int y,int x1,int y1)
	{
		availability av = new availability();
		if(a[x][y]==10)                                                         																	
		{
			if(y==y1||x==x1)																	
			{
				int check = av.check_availability(x1,y1);
				if(check == -1)																												
				{
					System.out.println("\n"+av.selfOccupied()+"\n");
				  	
				}

				else if(check == 0||check==1)
				{
					if(x==x1)
					{
						if(y>y1)
						{
							for(int u=y-1;u>=y1;u--)
							{
								int print = av.check_availability(x,u);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y<u)
								{
									continue;
								}
								else if(print == 1 && y1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}

						else
						{
							for(int u=y+1;u<=y1;u++)
							{
								int print = av.check_availability(x,u);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y>u)
								{
									continue;
								}
								else if(print == 1 && y1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}

					else if(y==y1)
					{
						if(x>x1)
						{
							for(int u=x-1;u>=x1;u--)
							{
								int print = av.check_availability(u,y);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x<u)
								{
									continue;
								}
								else if(print == 1 && x1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
						else
						{
							for(int u=x+1;u<=x1;u++)
							{
								int print = av.check_availability(u,y);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x>u)
								{
									continue;
								}
								else if(print == 1 && x1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}
					
				}
			}
			else
			{ 
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==20)                                                    																		   
		{
			int check = av.check_availability(x1,y1);
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(x1==x-2&&y1==y+1&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x-2&&y1==y-1&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x-1&&y1==y+2&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x-1&&y1==y-2&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}



			else if(x1==x+2&&y1==y+1&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x+2&&y1==y-1&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x+1&&y1==y+2&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x+1&&y1==y-2&&(check==0||check==1))
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else
			{ 
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==30)                                                  																		     
		{
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(x==x1 || y==y1)
			{
				System.out.println("\n"+av.invalid()+"\n");
			}
			else if(x1>x&&y1<y)
			{
				if(x1-x==y-y1)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
				
			}

			else if(x1<x&&y1>y)
			{
				if(x-x1==y1-y)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1<x&&y1<y)
			{
				if(x-x1==y-y1)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1>x&&y1>y)
			{
				if(x1-x==y1-y)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==40)                                                 																				      
		{
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(x1>x&&y1<y)
			{
				if(x1-x==y-y1)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
				
			}

			else if(x1<x&&y1>y)
			{
				if(x-x1==y1-y)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1<x&&y1<y)
			{
				if(x-x1==y-y1)
				{
					int f = y;
					for(int e=x-1;e>=x1;e--)
					{
						f--;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}

			else if(x1>x&&y1>y)
			{
				if(x1-x==y1-y)
				{
					int f = y;
					for(int e=x+1;e<=x1;e++)
					{
						f++;
						int print1 = av.check_availability(e,f);
						if(print1 == -1)
						{
							System.out.println("\n"+av.selfOccupied()+"\n");
							break;
						}
						else if(print1 == 0||print1 == 1)
						{
							if(e==x1 && f==y1 && print1 == 1)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(e==x1 && f==y1 && print1 == 0)
							{
								a[x1][y1] = a[x][y];
								a[x][y] = 0;
								draw();
								break;
							}
							else if(print1 == 0)
							{
								continue;
							}
							else
							{
								System.out.println("\n"+av.invalid()+"\n");
								break;
							}
						}
					}
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
			else if(y==y1||x==x1)																	
			{
				int check = av.check_availability(x1,y1);
				if(check == -1)																												
				{
					System.out.println("\n"+av.selfOccupied()+"\n");
				  	
				}

				else if(check == 0||check==1)
				{
					if(x==x1)
					{
						if(y>y1)
						{
							for(int u=y-1;u>=y1;u--)
							{
								int print = av.check_availability(x,u);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y<u)
								{
									continue;
								}
								else if(print == 1 && y1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}

						else
						{
							for(int u=y+1;u<=y1;u++)
							{
								int print = av.check_availability(x,u);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==y1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && y>u)
								{
									continue;
								}
								else if(print == 1 && y1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}

					else if(y==y1)
					{
						if(x>x1)
						{
							for(int u=x-1;u>=x1;u--)
							{
								int print = av.check_availability(u,y);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x<u)
								{
									continue;
								}
								else if(print == 1 && x1<u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
						else
						{
							for(int u=x+1;u<=x1;u++)
							{
								int print = av.check_availability(u,y);
								if(print == -1)
								{
									System.out.println("\n"+av.selfOccupied()+"\n");
									break;
								}
								else if(print == 1 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && u==x1)
								{
									a[x1][y1] = a[x][y];
									a[x][y] = 0;
									draw();
									break;
								}
								else if(print == 0 && x>u)
								{
									continue;
								}
								else if(print == 1 && x1>u)
								{
									System.out.println("\n"+av.invalid()+"\n");
									break;
								}
							}
						}
					}
					
				}
			}
			else
			{ 
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==50)                   //KING                               																			       
		{
			int check = av.check_availability(x1,y1);
			if(x==x1&&y==y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(check == -1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(check == 1 || check == 0)
			{
				if(x==x1)
				{
					if(y1==y+1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
   						draw();
   						
   					}
					else if(y1==y-1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
						
					}
					else
					{
						System.out.println("\n"+av.invalid()+"\n");
					}
				}
				else if(y==y1)
				{
					if(x1==x+1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
						
					}
					else if(x1==x-1)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
						
					}
					else
					{
						System.out.println("\n"+av.invalid()+"\n");
					}
				}
				else if(x1==x+1 && y1==y+1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
					
				}
				else if(x1==x-1 && y1==y-1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
									
				}
				else if(x1==x+1 && y1==y-1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
									
				}
				else if(x1==x-1 && y1==y+1)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
									
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(a[x][y]==90)
		{
			int check = av.check_availability(x1,y1);
			if(x == x1 && y == y1)
			{
				System.out.println("\n"+av.selfOccupied()+"\n");
			}
			else if(y==y1)
			{
				if((x==6&&y==0)||(x==6&&y==1)||(x==6&&y==2)||(x==6&&y==3)||(x==6&&y==4)||(x==6&&y==5)||(x==6&&y==6)||(x==6&&y==7))
				{
					if(x1==x-2)
					{
						if(check==0&&a[x-1][y]==0)
						{
							a[x1][y1] = a[x][y];
							a[x][y] = 0;
							draw();
						}
						else
						{
							System.out.println("\n"+av.invalid()+"\n");
						}
					}
					else if(x1==x-1&&check==0)
					{
						a[x1][y1] = a[x][y];
						a[x][y] = 0;
						draw();
					}
					else
					{
						System.out.println("\n"+av.invalid()+"\n");
					}
				}
				else if(x1==x-1&&check==0)
				{
					a[x1][y1] = a[x][y];
					a[x][y] = 0;
					draw();
				}
				else
				{
					System.out.println("\n"+av.invalid()+"\n");
				}
			}
			else if(x1==x-1&&y1==y-1&&check==1)
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else if(x1==x-1&&y1==y+1&&check==1)
			{
				a[x1][y1] = a[x][y];
				a[x][y] = 0;
				draw();
			}
			else
			{
				System.out.println("\n"+av.invalid()+"\n");
			}
		}
	}
}	



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class layout
{
	
	public String elephant(int a)
	{
		System.out.print("| ELEPHANT ("+a+") |");
		return "";
	}
	
	public String horse(int a) 
	{
		System.out.print("|   HORSE ("+a+")  |");
		return "";
	}
	
	public String camel(int a)
	{
		System.out.print("|   CAMEL ("+a+")  |");
		return "";
	}
	
	public String queen(int a)
	{
		System.out.print("|   QUEEN ("+a+")  |");
		return "";
	}
	
	public String king(int a)
	{
		System.out.print("|   KING ("+a+")   |");
		return "";
	}
	
	public String slave(int a) 
	{
		System.out.print("|   SLAVE ("+a+")  |");
		return "";
	}	

	public String empty(int a)
	{
		System.out.print("|              |");
		return "";
	}
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




class availability extends board
{
	public int assign(String lol)
	{
		if(lol.contains("a"))
			return 0;
		else if(lol.contains("b"))
			return 1;
		else if(lol.contains("c"))
			return 2;
		else if(lol.contains("d"))
			return 3;
		else if(lol.contains("e"))
			return 4;
		else if(lol.contains("f"))
			return 5;
		else if(lol.contains("g"))
			return 6;
		else
			return 7;
	}

	public int check_availability(int b,int c)
	{
		if(a[b][c]==1||a[b][c]==2||a[b][c]==3||a[b][c]==4||a[b][c]==5||a[b][c]==9)
		{
			return 1;
		}
		else if(a[b][c]==10||a[b][c]==20||a[b][c]==30||a[b][c]==40||a[b][c]==50||a[b][c]==90)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

	public String invalid()
	{
		return "XXXXXXXXXXXXXXXXXXXXXXXX INVALID CHOICE XXXXXXXXXXXXXXXXXXXXXXXXX";
	}

	public String selfOccupied()
	{
		return "XXXXXXXXXXXXXXXXXXXXXXXX Self Occupied XXXXXXXXXXXXXXXXXXXXXXXXXX";
	}
}





