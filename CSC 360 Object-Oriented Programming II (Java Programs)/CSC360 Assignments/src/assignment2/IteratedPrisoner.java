package assignment2;

/**
 * 
 */

/**
 * @author doylem3
 *
 */
public class IteratedPrisoner {

	private int iterations;
	private Prisoner one;  // assume this is me
	private Prisoner two;

	public static int DEFECT = 0;
	public static int COOPERATE = 1;

	// Result count
	private int[][] COUNT = { {0,0}, {0,0}};

	// How much time you will served based on the ratting of each prisoner
	private int[][] TIME = { {4, 0,},  {6, 1 }};

	public IteratedPrisoner(int iterations, Prisoner one, Prisoner two)
	{
		this.iterations = iterations;
		this.one = one;
		this.two = two;
	}

	public String toString() {
		StringBuffer info = new StringBuffer();

		info.append(String.format("Average jail time for me: %f years\n", 
				(COUNT[DEFECT][DEFECT]*TIME[DEFECT][DEFECT] + 
						COUNT[DEFECT][COOPERATE]*TIME[DEFECT][COOPERATE] + 
						COUNT[COOPERATE][DEFECT]*TIME[COOPERATE][DEFECT]+
						COUNT[COOPERATE][COOPERATE]*TIME[COOPERATE][COOPERATE])
						/100.0));
		info.append(String.format("Average jail time for my friend: %f years\n", (COUNT[DEFECT][DEFECT]*TIME[DEFECT][DEFECT] + 
				COUNT[DEFECT][COOPERATE]*TIME[COOPERATE][DEFECT] + 
				COUNT[COOPERATE][DEFECT]*TIME[DEFECT][COOPERATE]+
				COUNT[COOPERATE][COOPERATE]*TIME[COOPERATE][COOPERATE])/100.0));

		return new String(info);
	}
	// Play one round of Prisoner's Dilemma
	public void playRound() {

		boolean oneRatted = one.getDecision();
		boolean twoRatted = two.getDecision();
		int onePlay = COOPERATE;
		int twoPlay = COOPERATE;

		if (oneRatted & twoRatted)
		{
			onePlay = DEFECT;
			twoPlay = DEFECT;
		} else if (oneRatted)
			onePlay = DEFECT;
		else if (twoRatted)
			twoPlay = DEFECT;

		// how much time do they each get?
		one.notifyOutcome(TIME[onePlay][twoPlay]);
		two.notifyOutcome(TIME[twoPlay][onePlay]);

		// record result
		COUNT[onePlay][twoPlay]++;
	}

	public void play()
	{
		for (int i = 0; i < iterations; i++)
		{
			playRound();
		}

		//System.out.println(toString()); // print 
	}

	public double averageJailTime() {
		return (COUNT[DEFECT][DEFECT]*TIME[DEFECT][DEFECT] + 
				COUNT[DEFECT][COOPERATE]*TIME[DEFECT][COOPERATE] + 
				COUNT[COOPERATE][DEFECT]*TIME[COOPERATE][DEFECT]+
				COUNT[COOPERATE][COOPERATE]*TIME[COOPERATE][COOPERATE])
				/100.0;
	}

}
