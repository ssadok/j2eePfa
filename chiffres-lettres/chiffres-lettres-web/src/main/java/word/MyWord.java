package word;

import java.util.HashMap;

public class MyWord {
	private String myWord;
	private HashMap<Character,Integer> hm;
	public MyWord(String myWord) throws IllegalArgumentException
	{
		if (null == myWord)
			throw new IllegalArgumentException("myWord can not be null");
		else if (myWord.length() != 7)
			throw new IllegalArgumentException(String.format("The length of myWord must be 7\nThe word is %s\nThe lenght is %d",myWord,myWord.length()));
		this.myWord = myWord;
		stringToHM();
	}
	private void stringToHM()
	{
		hm = new HashMap<Character,Integer>();
		for (char c : myWord.toCharArray()) {
			hm.put(c, (hm.containsKey(c)?(int)hm.get(c):0)+1);
		}
	}
	private int compare(String os){
		if(os == null || os.length() != myWord.length())
			return -1;
		else if(myWord.equals(os))
			return 1;
		else
			return 0;
	}
	public String getFirstChar()
	{
		return myWord.charAt(0)+"";
	}
	public int[] comparePositon(String os)
	{
		int[] compArr;
		int compV = compare(os);
		if(compV == 1)
			compArr = new int[]{1,1,1,1,1,1,1};
		else if (compV == -1)
			compArr = new int[]{-1,-1,-1,-1,-1,-1,-1};
		else
		{
			compArr = new int[7];
			for(int i = 0; i < os.length(); i++)
			{
				char charAt = os.charAt(i);
				int nbChar;
				if(hm.containsKey(charAt) && (nbChar = hm.get(charAt)) > 0)
				{
					hm.put(charAt, nbChar-1);
					if(charAt == myWord.charAt(i))
						compArr[i] = 1;
					else
						compArr[i] = 0;
				}
				else
					compArr[i] = -1;
					
			}
		}
		return compArr;
	}
	
}
