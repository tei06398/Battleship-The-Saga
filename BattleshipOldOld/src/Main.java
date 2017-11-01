import java.util.Scanner;


public class Main {
	public static char p1ships[][] = new char[10][10];
	public static char p1attks[][] = new char[10][10];
	public static char p2ships[][] = new char[10][10];
	public static char p2attks[][] = new char[10][10];
	public static int cti(char c) {
		switch(c) {
		case 'A':
			return 1;
		case 'B':
			return 2;
		case 'C':
			return 3;
		case 'D':
			return 4;
		case 'E':
			return 5;
		case 'F':
			return 6;
		case 'G':
			return 7;
		case 'H':
			return 8;
		case 'I':
			return 9;
		case 'J':
			return 10;
		default:
			return 99;
		}
	}
	public static void gset(int x, int y, char p) {
		p1ships[y-1][x-1] = p;
		p1attks[y-1][x-1] = p;
		p2ships[y-1][x-1] = p;
		p2attks[y-1][x-1] = p;
	}
	public static void setupBoards() {
		for (int y = 1; y<=10; y++) {
			for (int x = 1; x<=10; x++) {
				gset(x,y,'~');
			}
		}
	}
	public static char p1get(int x, int y) {
		try {
			return p1ships[y-1][x-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return '!';
		}
	}
	public static boolean p1checkplace(int x, int y, int h, char p) {
		int size = 0;
		if (p == 'A') {
			size = 5;
		} else if (p == 'B') {
			size = 4;
		} else if (p == 'S') {
			size = 3;
		} else if (p == 'D') {
			size = 3;
		} else if (p == 'P') {
			size = 2;
		} else {
			return false;
		}
		for (int i = size; i>=1; i--) {
			if (h == 'N') {
				if (p1get(x,y+size) != '~') {
					return false;
				}
			} else if (h == 'S') {
				if (p1get(x,y-size) != '~') {
					return false;
				}
			} else if (h == 'E') {
				if (p1get(x+size,y) != '~') {
					return false;
				}
			} else if (h == 'W') {
				if (p1get(x-size,y) != '~') {
					return false;
				}
			}
		}
		return true;
	}
	public static void p1set(int x, int y, char p) {
		p1ships[y-1][x-1] = p;
		System.out.println("Worked.");
	}
	public static boolean p1attack(int x, int y) {
		return false;
	}
	public static boolean p2set(int x, int y, char p) {
		return false;
	}
	public static boolean p2attack(int x, int y) {
		return false;
	}
	public static Scanner in = new Scanner(System.in);
	
	public static boolean running = true;
	public static int stage = 0;
	public static int turn = 1;
	public static int p1slp[] = {1,1,1,1,1}; //A,B,S,D,P
	public static int p2slp[] = {1,1,1,1,1};
	public static int p1ss[] = {0,0,0,0,0};
	public static int p2ss[] = {0,0,0,0,0};
	public static void main(String args[]) {
		while(running) {
			if (stage == 0) {
				if (turn == 1) {
					if (p1slp[0] == 1) {
						System.out.println("Player 1: Place Aircraft Carrier");
						System.out.println("Enter X Value as a Letter A-J");
						char xc = in.next().charAt(0);
						if(cti(xc) == 99) {
							System.out.println("You didn't enter a Letter A-J\n");
						} else {
							int x = cti(xc);
							System.out.println("Enter Y Value 1-10");
							int y = in.nextInt();
							if (y > 10 || y < 1) {
								System.out.println("You didn't enter a Number 1-10");
							} else {
								System.out.println("Enter Direction of Ship Placement (N,E,S,W)");
								char h = in.next().charAt(0);
								if (!(h=='N' || h=='E' || h=='S' || h=='W')) {
									System.out.println("You didn't enter a Direction N,E,S,W");
								} else {
									if (p1checkplace(x,y,h,'A')) {
										for (int i = 5; i>=1; i--) {
											if (h == 'N') {
												System.out.println("Working...");
												p1set(x,y-i,'A');
											} else if (h == 'S') {
												p1set(x,y+i,'A');
											} else if (h == 'E') {
												p1set(x+i,y,'A');
											} else if (h == 'W') {
												p1set(x-i,y,'A');
											}
										}
										p1slp[0] = 0;
									} else {
										System.out.println("You cannot place the piece in this Position.");
									}
								}
							}
						}
					} else if (p1slp[1] == 1) {
						System.out.println("Player 1: Place Battleship");
						System.out.println("Enter X Value as a Letter A-J");
						char xc = in.next().charAt(0);
						if(cti(xc) == 99) {
							System.out.println("You didn't enter a Letter A-J\n");
						} else {
							int x = cti(xc);
							System.out.println("Enter Y Value 1-10");
							int y = in.nextInt();
							if (y > 10 || y < 1) {
								System.out.println("You didn't enter a Number 1-10");
							} else {
								System.out.println("Enter Direction of Ship Placement (N,E,S,W)");
								char h = in.next().charAt(0);
								if (!(h=='N' || h=='E' || h=='S' || h=='W')) {
									System.out.println("You didn't enter a Direction N,E,S,W");
								} else {
									if (p1checkplace(x,y,h,'B')) {
										for (int i = 4; i>=1; i--) {
											if (h == 'N') {
												p1set(x,y+i,'B');
											} else if (h == 'S') {
												p1set(x,y-i,'B');
											} else if (h == 'E') {
												p1set(x+i,y,'B');
											} else if (h == 'W') {
												p1set(x-i,y,'B');
											}
										}
										p1slp[1] = 0;
									}
								}
							}
						} 
					} else if (p1slp[2] == 1) {
						System.out.println("Player 1: Place Submarine");
						System.out.println("Enter X Value as a Letter A-J");
						char xc = in.next().charAt(0);
						if(cti(xc) == 99) {
							System.out.println("You didn't enter a Letter A-J\n");
						} else {
							int x = cti(xc);
							System.out.println("Enter Y Value 1-10");
							int y = in.nextInt();
							if (y > 10 || y < 1) {
								System.out.println("You didn't enter a Number 1-10");
							} else {
								System.out.println("Enter Direction of Ship Placement (N,E,S,W)");
								char h = in.next().charAt(0);
								if (!(h=='N' || h=='E' || h=='S' || h=='W')) {
									System.out.println("You didn't enter a Direction N,E,S,W");
								} else {
									if (p1checkplace(x,y,h,'S')) {
										for (int i = 3; i>=1; i--) {
											if (h == 'N') {
												p1set(x,y+i,'S');
											} else if (h == 'S') {
												p1set(x,y-i,'S');
											} else if (h == 'E') {
												p1set(x+i,y,'S');
											} else if (h == 'W') {
												p1set(x-i,y,'S');
											}
										}
										p1slp[2] = 0;
									}
								}
							}
						} 
					} else if (p1slp[3] == 1) {
						System.out.println("Player 1: Place Destroyer");
						System.out.println("Enter X Value as a Letter A-J");
						char xc = in.next().charAt(0);
						if(cti(xc) == 99) {
							System.out.println("You didn't enter a Letter A-J\n");
						} else {
							int x = cti(xc);
							System.out.println("Enter Y Value 1-10");
							int y = in.nextInt();
							if (y > 10 || y < 1) {
								System.out.println("You didn't enter a Number 1-10");
							} else {
								System.out.println("Enter Direction of Ship Placement (N,E,S,W)");
								char h = in.next().charAt(0);
								if (!(h=='N' || h=='E' || h=='S' || h=='W')) {
									System.out.println("You didn't enter a Direction N,E,S,W");
								} else {
									if (p1checkplace(x,y,h,'D')) {
										for (int i = 3; i>=1; i--) {
											if (h == 'N') {
												p1set(x,y+i,'D');
											} else if (h == 'S') {
												p1set(x,y-i,'D');
											} else if (h == 'E') {
												p1set(x+i,y,'D');
											} else if (h == 'W') {
												p1set(x-i,y,'D');
											}
										}
										p1slp[3] = 0;
									}
								}
							}
						} 
					} else if (p1slp[4] == 1) {
						System.out.println("Player 1: Place Patrol Boat");
						System.out.println("Enter X Value as a Letter A-J");
						char xc = in.next().charAt(0);
						if(cti(xc) == 99) {
							System.out.println("You didn't enter a Letter A-J\n");
						} else {
							int x = cti(xc);
							System.out.println("Enter Y Value 1-10");
							int y = in.nextInt();
							if (y > 10 || y < 1) {
								System.out.println("You didn't enter a Number 1-10");
							} else {
								System.out.println("Enter Direction of Ship Placement (N,E,S,W)");
								char h = in.next().charAt(0);
								if (!(h=='N' || h=='E' || h=='S' || h=='W')) {
									System.out.println("You didn't enter a Direction N,E,S,W");
								} else {
									if (p1checkplace(x,y,h,'P')) {
										for (int i = 2; i>=1; i--) {
											if (h == 'N') {
												p1set(x,y+i,'P');
											} else if (h == 'S') {
												p1set(x,y-i,'P');
											} else if (h == 'E') {
												p1set(x+i,y,'P');
											} else if (h == 'W') {
												p1set(x-i,y,'P');
											}
										}
										p1slp[4] = 0;
									}
								}
							}
						} 
					}
				}
			}
		}
	}
	
}
