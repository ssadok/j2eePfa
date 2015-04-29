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
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>(this.hm);
		int[] compArr = new int[]{-1,-1,-1,-1,-1,-1,-1};
		int compV = compare(os);
		if(compV == 1)
			compArr = new int[]{1,1,1,1,1,1,1};
		else
		{
			char charAt;
			int nbChar;
			for(int i = 0; i < os.length(); i++)
			{
				charAt = os.charAt(i);
				if(charAt == myWord.charAt(i))
				{
					hm.put(charAt, hm.get(charAt)-1);
					compArr[i] = 1;
				}
			}
			for(int i = 0; i < os.length(); i++)
			{
				charAt = os.charAt(i);
				if(hm.containsKey(charAt) && (nbChar = hm.get(charAt)) > 0)
				{
					//System.out.println(charAt + " = " + nbChar + "\n");
					hm.put(charAt, nbChar-1);
					if(compArr[i] == -1 && charAt != myWord.charAt(i))
						compArr[i] = 0;
				}
					
			}
		}
		return compArr;
	}
	
}
