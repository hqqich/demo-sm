package org.example;

import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jce.interfaces.ECPrivateKey;

public interface Sm2PrivateKey extends ECPrivateKey {
	ECPrivateKeyParameters getPrivateKeyParameters();

	byte[] getWithId();

	void setWithId(byte[] withId);
}
