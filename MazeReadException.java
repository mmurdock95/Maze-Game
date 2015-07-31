public class MazeReadException extends Exception
{
	String message;
	String line;
	int lineNumber;

	public MazeReadException(String message, String line, int lineNumber)
	{
		super(message);
		this.line=line;
		this.lineNumber=lineNumber;
	}

	public String getLine()
	{
		return line;
	}

	public int getLineNum()
	{
		return lineNumber;
	}


}