package it.univpm.SpringBootApplication.exception;

public class JobsNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public JobsNotFoundException() {
		super();
	}
	
	public JobsNotFoundException(String msg) {
		super(msg);
	}

}
