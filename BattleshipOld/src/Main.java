import java.util.InputMismatchException;
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
	public static char p1gets(int x, int y) {
		try {
			return p1ships[y-1][x-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return '!';
		}
	}
	public static char p1geta(int x, int y) {
		try {
			return p1attks[y-1][x-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return '!';
		}
	}
	public static char p2gets(int x, int y) {
		try {
			return p2ships[y-1][x-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return '!';
		}
	}
	public static char p2geta(int x, int y) {
		try {
			return p2attks[y-1][x-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return '!';
		}
	}
	public static void p1pships() {
		System.out.println("   A B C D E F G H I J");
		for (int y = 1; y<=10; y++) {
			if (y != 10) {
				System.out.print(y + "  ");
			} else {
				System.out.print(y + " ");
			}
			for (int x = 1; x<=10; x++) {
				System.out.print(p1gets(x, y) + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public static void p1pattacks() {
		System.out.println("   A B C D E F G H I J");
		for (int y = 1; y<=10; y++) {
			if (y != 10) {
				System.out.print(y + "  ");
			} else {
				System.out.print(y + " ");
			}
			for (int x = 1; x<=10; x++) {
				System.out.print(p1geta(x, y) + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public static void p2pships() {
		System.out.println("   A B C D E F G H I J");
		for (int y = 1; y<=10; y++) {
			if (y != 10) {
				System.out.print(y + "  ");
			} else {
				System.out.print(y + " ");
			}
			for (int x = 1; x<=10; x++) {
				System.out.print(p2gets(x, y) + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public static void p2pattacks() {
		System.out.println("   A B C D E F G H I J");
		for (int y = 1; y<=10; y++) {
			if (y != 10) {
				System.out.print(y + "  ");
			} else {
				System.out.print(y + " ");
			}
			for (int x = 1; x<=10; x++) {
				System.out.print(p2geta(x, y) + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public static void p1set(int x, int y, char p) {
		p1ships[y-1][x-1] = p;
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
	public static String xs;
	public static char x;
	public static int y;
	public static String hs;
	public static char h;
	
	public static void main(String args[]) {
		if (!running) {
			setupBoards();
			running=true;
		}
		while(running) {
			if (stage == 0) {
				if (p1slp[0] == 1) {
					System.out.println("Player 1: Place Aircraft Carrier");
					System.out.println("Enter a Letter A-J:");
					xs = in.nextLine();
					try {
						x = xs.charAt(0);
					} catch (StringIndexOutOfBoundsException sioobe) {
						System.out.println("Letter " + x + " selected from previous Entry\n");
					}
					if (cti(x) != 99) {
						System.out.println("Enter a Number 1-10:");
						try {
							y = in.nextInt();
						} catch (InputMismatchException ime) {
							System.out.println("You entered an invalid Number\n");
						}
						if (y>=1 && y<=10) {
							System.out.println("Enter a Heading N,E,S,W:");
							hs = in.nextLine();
							try {
								h = hs.charAt(0);
							} catch (StringIndexOutOfBoundsException sioobe) {
							}
							if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
								if (h == 'N') {
									if (y-4 >= 1) {
										for (int i = 4; i>=0; i--) {
											if (p1gets(cti(x), y-i) == '~') {
												p1set(cti(x), y-i, 'A');
											} else {
												System.out.println("Impossible Placement: Ship already Exists in Coordinates");
											}
										}
										p1slp[0] = 0;
									} else {
										System.out.println("Impossible Placement: Off the Board\n");
									}
								} else if (h == 'E') {
									if (cti(x)+4 <= 10) {
										for (int i = 4; i>=0; i--) {
											if (p1gets(cti(x)+i, y) == '~') {
												p1set(cti(x)+i, y, 'A');
											} else {
												System.out.println("Impossible Placement: Ship already Exists in Coordinates");
											}
										}
										p1slp[0] = 0;
									} else {
										System.out.println("Impossible Placement: Off the Board\n");
									}
								} else if (h == 'S') {
									if (y+4 <= 10) {
										for (int i = 4; i>=0; i--) {
											if (p1gets(cti(x), y+i) == '~') {
												p1set(cti(x), y+i, 'A');
											} else {
												System.out.println("Impossible Placement: Ship already Exists in Coordinates");
											}
										}
										p1slp[0] = 0;
									} else {
										System.out.println("Impossible Placement: Off the Board\n");
									}
								} if (h == 'W') {
									if (cti(x)-4 >= 1) {
										for (int i = 4; i>=0; i--) {
											if (p1gets(cti(x)-i, y) == '~') {
												p1set(cti(x)-i, y, 'A');
											} else {
												System.out.println("Impossible Placement: Ship already Exists in Coordinates");
											}
											
										}
										p1slp[0] = 0;
									} else {
										System.out.println("Impossible Placement: Off the Board\n");
									}
								}
							} else {
								System.out.println("You entered an invalid Heading\n");
							}
						} else {
							System.out.println("You entered an invalid Number\n");
						}
					} else {
						System.out.println("You entered an invalid Character\n");
					}
				} else  {
					p1pships();
					running = false;
				}
			}
		}
	}
}
