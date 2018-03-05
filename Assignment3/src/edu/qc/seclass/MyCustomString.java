package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {
	String s;
	int n;
	
    public String getString(){
    	if(s==null)
    		return null;
    	else
    		return s;
    }

  
    public void setString(String string)
    {
    	s=string;
    }


    public int countNumbers(){
    	if(s==null){
    		throw new NullPointerException("String is empty");
       	}
    	else if(s.isEmpty())
    		return 0;
    	else
    	{
    		//String temp="";
    		int count=0;
    		for(char c : s.toCharArray()){
    			if(c>='0'&& c<='9')
    				//temp+=c;
    				;
    			else{
    				++count;
    				//temp="";
    			}
    		}
    		return count;
    	}
    }

    
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd){
    	if(n<=0){
    		throw new IllegalArgumentException("The value of n must be greater than zero");
    	}
    	else if(n>0 && s==null)
    		throw new NullPointerException("The string is NULL");
    	else if(s.isEmpty() || n>s.length()){
    		return "";
    	}
    	else if(startFromEnd==true)
    	{
    		String ans="";
    		String j=new StringBuilder(s).reverse().toString();
    		for(int i=1; i<j.length();i*=n){
    			ans+=j.charAt(i);
    		}    		
    		return j= new StringBuilder(ans).reverse().toString();
    	}
    	else if(startFromEnd==false)
    	{
    		String ans="";
    		for(int i=1; i<s.length();i*=n){
    			ans+=s.charAt(i);
    		} 
    		return ans;
    	}
    	else
    		return "";
    }

    
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition){
    	if(startPosition>endPosition){
    		throw new IllegalArgumentException("The StartPosition has to be less than the endPosition");
    	}
    	else if(startPosition<=endPosition || startPosition<s.length()-1 || startPosition>s.length()|| endPosition<s.length()-1 || endPosition>s.length()){
    		throw new MyIndexOutOfBoundsException("Error");
      	}
    	else if(startPosition<=endPosition && startPosition>0&&s!=null){
    		throw new NullPointerException("String is NULL");
    	}
    	else
    	{	String ans="";
    		for(char c : s.toCharArray()){
    			if(c>='0'&& c<='9')
    			{
    				switch (c){
    				case '0':	ans+="Zero";break;
    				case '1':	ans+="One";break;
    				case '2':	ans+="Two";break;
    				case '3':	ans+="Three";break;
    				case '4':	ans+="Four";break;
    				case '5':	ans+="Five";break;
    				case '6':	ans+="Six";break;
    				case '7':	ans+="Seven";break;
    				case '8':	ans+="Eight";break;
    				case '9':	ans+="Nine";break;
   				}
    		}
    			else{
    				ans+=c;
    			}
    	}
    		s=ans;
    	
    }
    
}
}

