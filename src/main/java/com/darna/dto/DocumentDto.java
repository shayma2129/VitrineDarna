package com.darna.dto;

public class DocumentDto {
	
	private long idDocument;
	private byte[] file;
	private String path_doc;
	public DocumentDto(long idDocument, byte[] file, String path_doc) {
		super();
		this.idDocument = idDocument;
		this.file = file;
		this.path_doc = path_doc;
	}
	public DocumentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(long idDocument) {
		this.idDocument = idDocument;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getPath_doc() {
		return path_doc;
	}
	public void setPath_doc(String path_doc) {
		this.path_doc = path_doc;
	}
	
	

}
