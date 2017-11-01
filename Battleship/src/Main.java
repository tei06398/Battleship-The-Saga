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
	public static void p1seta(int x, int y, char p) {
		p1attks[y-1][x-1] = p;
	}
	public static void p1attack(int x, int y) {
		if (p2gets(x,y) != '~') {
			System.out.println("HIT!");
			p1seta(x,y,'!');
			p2set(x,y,Character.toLowerCase(p2gets(x,y)));
			p2checksunk();
		} else {
			System.out.println("MISS!");
			p1seta(x,y,'.');
		}
	}
	public static int p1A=0;
	public static int p1B=0;
	public static int p1S=0;
	public static int p1D=0;
	public static int p1P=0;
	public static void p1checksunk() {
		p1A=0;
		p1B=0;
		p1S=0;
		p1D=0;
		p1P=0;
		for (int y = 1; y<=10; y++) {
			for (int x = 1; x<=10; x++) {
				if (p1gets(x,y) == 'A') {
					p1A+=1;
				} else if (p1gets(x,y) == 'B') {
					p1B+=1;
				} else if (p1gets(x,y) == 'S') {
					p1S+=1;
				} else if (p1gets(x,y) == 'D') {
					p1D+=1;
				} else if (p1gets(x,y) == 'P') {
					p1P+=1;
				}
			}
		}
		if (p1ss[0] == 0 && p1A == 0) {
			System.out.println("You've sunk Player 1's Aircraft Carrier (Size 5)");
			p1ss[0] = 1;
		} else if (p1ss[1] == 0 && p1B == 0) {
			System.out.println("You've sunk Player 1's Battleship (Size 4)");
			p1ss[1] = 1;
		} else if (p1ss[2] == 0 && p1S == 0) {
			System.out.println("You've sunk Player 1's Submarine (Size 3)");
			p1ss[2] = 1;
		} else if (p1ss[3] == 0 && p1D == 0) {
			System.out.println("You've sunk Player 1's Destroyer (Size 3)");
			p1ss[3] = 1;
		} else if (p1ss[4] == 0 && p1P == 0) {
			System.out.println("You've sunk Player 1's Patrol Boat (Size 2)");
			p1ss[4] = 1;
		}
		if (p1ss[0] == 1 && p1ss[1] == 1 && p1ss[2] == 1 && p1ss[3] == 1 && p1ss[4] == 1) {
			System.out.println("PLAYER 2 WINS!");
			p2pships();
			System.exit(0);
		}
	}
	public static int p2A=0;
	public static int p2B=0;
	public static int p2S=0;
	public static int p2D=0;
	public static int p2P=0;
	public static void p2checksunk() {
		p2A=0;
		p2B=0;
		p2S=0;
		p2D=0;
		p2P=0;
		for (int y = 1; y<=10; y++) {
			for (int x = 1; x<=10; x++) {
				if (p2gets(x,y) == 'A') {
					p2A+=1;
				} else if (p2gets(x,y) == 'B') {
					p2B+=1;
				} else if (p2gets(x,y) == 'S') {
					p2S+=1;
				} else if (p2gets(x,y) == 'D') {
					p2D+=1;
				} else if (p2gets(x,y) == 'P') {
					p2P+=1;
				}
			}
		}
		if (p2ss[0] == 0 && p2A == 0) {
			System.out.println("You've sunk Player 2's Aircraft Carrier (Size 5)");
			p2ss[0] = 1;
		} else if (p2ss[1] == 0 && p2B == 0) {
			System.out.println("You've sunk Player 2's Battleship (Size 4)");
			p2ss[1] = 1;
		} else if (p2ss[2] == 0 && p2S == 0) {
			System.out.println("You've sunk Player 2's Submarine (Size 3)");
			p2ss[2] = 1;
		} else if (p2ss[3] == 0 && p2D == 0) {
			System.out.println("You've sunk Player 2's Destroyer (Size 3)");
			p2ss[3] = 1;
		} else if (p2ss[4] == 0 && p2P == 0) {
			System.out.println("You've sunk Player 2's Patrol Boat (Size 2)");
			p2ss[4] = 1;
		}
		if (p2ss[0] == 1 && p2ss[1] == 1 && p2ss[2] == 1 && p2ss[3] == 1 && p2ss[4] == 1) {
			System.out.println("PLAYER 1 WINS!");
			p1pships();
			System.exit(0);
		}
	}
	public static void p2set(int x, int y, char p) {
		p2ships[y-1][x-1] = p;
	}
	public static void p2seta(int x, int y, char p) {
		p2attks[y-1][x-1] = p;
	}
	public static void p2attack(int x, int y) {
		if (p1gets(x,y) != '~') {
			System.out.println("HIT!");
			p2seta(x,y,'!');
			p1set(x,y,Character.toLowerCase(p1gets(x,y)));
			p1checksunk();
		} else {
			System.out.println("MISS!");
			p2seta(x,y,'.');
		}
	}
	public static Scanner in = new Scanner(System.in);
	
	public static boolean running = true;
	public static int stage = 0;
	public static int turn = 1;
	public static int p1slp[] = {1,1,1,1,1}; //A,B,S,D,P
	public static int p2slp[] = {1,1,1,1,1};
	public static int p1ss[] = {0,0,0,0,0};
	public static int p2ss[] = {0,0,0,0,0};
	
	public static int x = 0;
	public static int y = 0;
	public static char h = ' ';
	public static boolean placeable = true;
	public static void main(String args[]) {
		setupBoards();
		while (running) {
			placeable = true;
			if (stage == 0) {
				if (turn == 1) {
					p1pships();
					if (p1slp[0] == 1) {
						System.out.println("Player 1: Place Aircraft Carrier:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 4 >= 1) {
											for (int yi = 0; yi <= 4; yi++) {
												if (p1gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 4; yi++) {
													p1set(x,y-yi,'A');
												}
												p1slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 4 <= 10) {
											for (int xi = 0; xi <= 4; xi++) {
												if (p1gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 4; xi++) {
													p1set(x+xi,y,'A');
												}
												p1slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 4 <= 10) {
											for (int yi = 0; yi <= 4; yi++) {
												if (p1gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 4; yi++) {
													p1set(x,y+yi,'A');
												}
												p1slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 4 >= 1) {
											for (int xi = 0; xi <= 4; xi++) {
												if (p1gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 4; xi++) {
													p1set(x-xi,y,'A');
												}
												p1slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p1slp[1] == 1) {
						System.out.println("Player 1: Place Battleship:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 3 >= 1) {
											for (int yi = 0; yi <= 3; yi++) {
												if (p1gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 3; yi++) {
													p1set(x,y-yi,'B');
												}
												p1slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 3 <= 10) {
											for (int xi = 0; xi <= 3; xi++) {
												if (p1gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 3; xi++) {
													p1set(x+xi,y,'B');
												}
												p1slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 3 <= 10) {
											for (int yi = 0; yi <= 3; yi++) {
												if (p1gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 3; yi++) {
													p1set(x,y+yi,'B');
												}
												p1slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 3 >= 1) {
											for (int xi = 0; xi <= 3; xi++) {
												if (p1gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 3; xi++) {
													p1set(x-xi,y,'B');
												}
												p1slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p1slp[2] == 1) {
						System.out.println("Player 1: Place Submarine:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 2 >= 1) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p1gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p1set(x,y-yi,'S');
												}
												p1slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 2 <= 10) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p1gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p1set(x+xi,y,'S');
												}
												p1slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 2 <= 10) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p1gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p1set(x,y+yi,'S');
												}
												p1slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 2 >= 1) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p1gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p1set(x-xi,y,'S');
												}
												p1slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p1slp[3] == 1) {
						System.out.println("Player 1: Place Destroyer:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 2 >= 1) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p1gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p1set(x,y-yi,'D');
												}
												p1slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 2 <= 10) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p1gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p1set(x+xi,y,'D');
												}
												p1slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 2 <= 10) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p1gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p1set(x,y+yi,'D');
												}
												p1slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 2 >= 1) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p1gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p1set(x-xi,y,'D');
												}
												p1slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p1slp[4] == 1) {
						System.out.println("Player 1: Place Patrol Boat:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 1 >= 1) {
											for (int yi = 0; yi <= 1; yi++) {
												if (p1gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 1; yi++) {
													p1set(x,y-yi,'P');
												}
												p1slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 1 <= 10) {
											for (int xi = 0; xi <= 1; xi++) {
												if (p1gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 1; xi++) {
													p1set(x+xi,y,'P');
												}
												p1slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 1 <= 10) {
											for (int yi = 0; yi <= 1; yi++) {
												if (p1gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 1; yi++) {
													p1set(x,y+yi,'P');
												}
												p1slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 1 >= 1) {
											for (int xi = 0; xi <= 1; xi++) {
												if (p1gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 1; xi++) {
													p1set(x-xi,y,'P');
												}
												p1slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else {
						turn = 2;
					}
				} else if (turn == 2) {
					//TODO: DO THIS AND CHANGE THINGS TO P2
					p2pships();
					if (p2slp[0] == 1) {
						System.out.println("Player 2: Place Aircraft Carrier:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 4 >= 1) {
											for (int yi = 0; yi <= 4; yi++) {
												if (p2gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 4; yi++) {
													p2set(x,y-yi,'A');
												}
												p2slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 4 <= 10) {
											for (int xi = 0; xi <= 4; xi++) {
												if (p2gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 4; xi++) {
													p2set(x+xi,y,'A');
												}
												p2slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 4 <= 10) {
											for (int yi = 0; yi <= 4; yi++) {
												if (p2gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 4; yi++) {
													p2set(x,y+yi,'A');
												}
												p2slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 4 >= 1) {
											for (int xi = 0; xi <= 4; xi++) {
												if (p2gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 5;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 4; xi++) {
													p2set(x-xi,y,'A');
												}
												p2slp[0] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p2slp[1] == 1) {
						System.out.println("Player 2: Place Battleship:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 3 >= 1) {
											for (int yi = 0; yi <= 3; yi++) {
												if (p2gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 3; yi++) {
													p2set(x,y-yi,'B');
												}
												p2slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 3 <= 10) {
											for (int xi = 0; xi <= 3; xi++) {
												if (p2gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 3; xi++) {
													p2set(x+xi,y,'B');
												}
												p2slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 3 <= 10) {
											for (int yi = 0; yi <= 3; yi++) {
												if (p2gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 3; yi++) {
													p2set(x,y+yi,'B');
												}
												p2slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 3 >= 1) {
											for (int xi = 0; xi <= 3; xi++) {
												if (p2gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 4;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 3; xi++) {
													p2set(x-xi,y,'B');
												}
												p2slp[1] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p2slp[2] == 1) {
						System.out.println("Player 2: Place Submarine:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 2 >= 1) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p2gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p2set(x,y-yi,'S');
												}
												p2slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 2 <= 10) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p2gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p2set(x+xi,y,'S');
												}
												p2slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 2 <= 10) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p2gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p2set(x,y+yi,'S');
												}
												p2slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 2 >= 1) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p2gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p2set(x-xi,y,'S');
												}
												p2slp[2] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p2slp[3] == 1) {
						System.out.println("Player 2: Place Destroyer:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 2 >= 1) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p2gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p2set(x,y-yi,'D');
												}
												p2slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 2 <= 10) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p2gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p2set(x+xi,y,'D');
												}
												p2slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 2 <= 10) {
											for (int yi = 0; yi <= 2; yi++) {
												if (p2gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 2; yi++) {
													p2set(x,y+yi,'D');
												}
												p2slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 2 >= 1) {
											for (int xi = 0; xi <= 2; xi++) {
												if (p2gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 3;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 2; xi++) {
													p2set(x-xi,y,'D');
												}
												p2slp[3] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else if (p2slp[4] == 1) {
						System.out.println("Player 2: Place Patrol Boat:");
						System.out.println("Enter Letter corresponding to X coordinate:");
						x = cti(in.next().charAt(0));
						System.out.println("Enter Number corresponding to Y coordinate:");
						y = in.nextInt();
						System.out.println("Enter Letter N,E,S,W corresponding to Heading:");
						h = in.next().charAt(0);
						if (x != 99) {
							if (y <= 10 && y >= 1) {
								if (h == 'N' || h == 'E' || h == 'S' || h == 'W') {
									if (h == 'N') {
										if (y - 1 >= 1) {
											for (int yi = 0; yi <= 1; yi++) {
												if (p2gets(x,y-yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 1; yi++) {
													p2set(x,y-yi,'P');
												}
												p2slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'E') {
										if (x + 1 <= 10) {
											for (int xi = 0; xi <= 1; xi++) {
												if (p2gets(x+xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 1; xi++) {
													p2set(x+xi,y,'P');
												}
												p2slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'S') {
										if (y + 1 <= 10) {
											for (int yi = 0; yi <= 1; yi++) {
												if (p2gets(x,y+yi) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													yi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int yi = 0; yi <= 1; yi++) {
													p2set(x,y+yi,'P');
												}
												p2slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									} else if (h == 'W') {
										if (x - 1 >= 1) {
											for (int xi = 0; xi <= 1; xi++) {
												if (p2gets(x-xi,y) == '~') {
													//System.out.println("Valid Placement!");
												} else {
													xi = 2;
													placeable = false;
													System.out.println("Invalid Placement! Try again.");
												}
											}
											if (placeable) {
												for (int xi = 0; xi <= 1; xi++) {
													p2set(x-xi,y,'P');
												}
												p2slp[4] = 0;
											}
										} else {
											System.out.println("Invalid Placement! Try again.");
										}
									}
								} else {
									System.out.println("Invalid Heading! Try again.");
								}
							} else {
								System.out.println("Invalid Y coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid X coordinate! Try again.");
						}
					} else {
						stage = 1;
						turn = 1;
					}
				}
			} else if (stage == 1) {
				if (turn == 1) {
					p1pattacks();
					System.out.println("Player 1: Guess a Position:");
					System.out.println("Enter Letter corresponding to X coordinate:");
					x = cti(in.next().charAt(0));
					System.out.println("Enter Number corresponding to Y coordinate:");
					y = in.nextInt();
					if (x != 99) {
						if (y <= 10 && y >= 1) {
							if (p1geta(x,y) == '~') {
								p1attack(x,y);
								turn = 2;
							} else {
								System.out.println("Already tried this coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid Y coordinate! Try again.");
						}
					} else {
						System.out.println("Invalid X coordinate! Try again.");
					}
				} else if (turn == 2) {
					p2pattacks();
					System.out.println("Player 2: Guess a Position:");
					System.out.println("Enter Letter corresponding to X coordinate:");
					x = cti(in.next().charAt(0));
					System.out.println("Enter Number corresponding to Y coordinate:");
					y = in.nextInt();
					if (x != 99) {
						if (y <= 10 && y >= 1) {
							if (p2geta(x,y) == '~') {
								p2attack(x,y);
								turn = 1;
							} else {
								System.out.println("Already tried this coordinate! Try again.");
							}
						} else {
							System.out.println("Invalid Y coordinate! Try again.");
						}
					} else {
						System.out.println("Invalid X coordinate! Try again.");
					}
				}
			}
		}
	}
}
