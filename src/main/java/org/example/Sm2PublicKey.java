package org.example;

import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.interfaces.ECPublicKey;

public interface Sm2PublicKey extends ECPublicKey {
	ECPublicKeyParameters getPublicKeyParameters();

	byte[] getWithId();

	void setWithId(byte[] withId);
}
