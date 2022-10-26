package com.venancio.blanco.exercises2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class NewWritingWay extends ObjectOutputStream {

	public NewWritingWay(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeStreamHeader() throws IOException {
		reset();
	}

}
