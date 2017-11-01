
public class Main {
	public static char p1b[][] /*player1board*/ = new char[10][10];
	public static char p2b[][] /*player2board*/ = new char[10][10];
	public static void spp1(int x, int y, char piece) /*setPiecePlayer1*/ {
		p1b[y-1][x-1] = piece; 
	}
	
	public static void spp2(int x, int y, char piece) /*setPiecePlayer2*/ {
		p2b[y-1][x-1] = piece; 
	}
	
	public static char gpp1(int x, int y) {
		return p1b[y-1][x-1];
	}
	public static void setupBoards() {
		for (int x=1; x<=10; x++) {
			for (int y=1; y<=10; y++) {
				spp1(x, y, '/');
			}
		}
	}
	
	public static int cti /*charToInt*/ (char letter) {
		int integer;
		switch(letter) {
		case 'A':
			integer = 1;
			break;
		case 'B':
			integer = 2;
			break;
		case 'C':
			integer = 3;
			break;
		case 'D':
			integer = 4;
			break;
		case 'E':
			integer = 5;
			break;
		case 'F':
			integer = 6;
			break;
		case 'G':
			integer = 7;
			break;
		case 'H':
			integer = 8;
			break;
		case 'I':
			integer = 9;
			break;
		case 'J':
			integer = 10;
			break;
		default:
			integer = 99;	
		}
		return integer;
	}
	public static boolean hv(char heading) /*headingVerify*/ {
		switch(heading) {
		case 'N':
		case 'E':
		case 'S':
		case 'W':
			return true;
		default:
			return false;
		}
	}
	public static boolean pv(char piece) /*pieceVerify*/ {
		switch(piece) {
		case 'A': //Aircraft Carrier
		case 'B': //Battleship
		case 'S': //Submarine
		case 'D': //Destroyer
		case 'P': //Patrol Boat
			return true;
		default:
			return false;
		}
	}
	public static boolean ppp1(char xc, int y, char piece, char heading) /*placePiecePlayer1*/ {
		xc = Character.toUpperCase(xc);
		piece = Character.toUpperCase(piece);
		heading = Character.toUpperCase(heading);
		int x = cti(xc);
		if (x == 99 || 1<y && y>10 || !hv(heading) || !pv(piece)) {
			return false;
		} else {
			if (piece == 'A') {
				if (heading == 'N') {
					if (x<5) {
						return false;
					} else {
						for (int i = x; i <= x+5; i++) {
							if (gpp1(i,y) != '/') {
								return false;
							} else {
								                           
							}
						}
					}
				}
			}
			
			
		}
	}
	public static void main(String args[]) {
		setupBoards();
	}
}
