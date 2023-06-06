package pakageJDBC.Service;

import java.util.Date;

public class C02Notice {
	private int id ;
	private String title;
	private String writerId;
	private Date regData;
	private String content;
	private int hit;
	private String files;
	
	public C02Notice() {
	}
	
	public C02Notice(int id, String title, String writerId, Date regData, String content, int hit, String files) {
		
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.regData = regData;
		this.content = content;
		this.hit = hit;
		this.files = files;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public Date getRegData() {
		return regData;
	}
	public void setRegData(Date regData) {
		this.regData = regData;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String getFiles) {
		this.files = getFiles;
	}
}


