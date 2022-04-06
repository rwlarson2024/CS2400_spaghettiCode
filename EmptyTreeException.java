// package TreePackage

/** Class for running the EmptyTreeException. */
public class EmptyTreeException extends RuntimeException
{
	/** Default constructor */
	public EmptyTreeException()
	{
		this(null);
	}

	/** Constructor with a given message */
	public EmptyTreeException(String message)
	{
		super(message);
	}
}