package groupe1.filrouge.entity;

public class LogResult {

	private boolean meca;
	
	private boolean com;

	public LogResult(boolean meca, boolean com) {
		super();
		this.meca = meca;
		this.com = com;
	}

	public boolean isMeca() {
		return meca;
	}

	public void setMeca(boolean meca) {
		this.meca = meca;
	}

	public boolean isCom() {
		return com;
	}

	public void setCom(boolean com) {
		this.com = com;
	}
	
}
