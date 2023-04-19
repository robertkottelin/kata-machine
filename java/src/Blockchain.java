import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

class Block {
    int index;
    String data;
    String previousHash;
    String hash;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String input = index + data + previousHash;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hashString = new StringBuilder();
            for (byte b : hashBytes) {
                hashString.append(String.format("%02x", b));
            }
            return hashString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Blockchain {
    LinkedList<Block> chain;

    public Blockchain() {
        chain = new LinkedList<>();
        chain.add(new Block(0, "Genesis Block", "0"));
    }

    public void addBlock(String data) {
        Block lastBlock = chain.getLast();
        chain.add(new Block(lastBlock.index + 1, data, lastBlock.hash));
    }

    public static void main(String[] args) {
        Blockchain myBlockchain = new Blockchain();
        myBlockchain.addBlock("Block 1");
        myBlockchain.addBlock("Block 2");
        myBlockchain.addBlock("Block 3");

        for (Block block : myBlockchain.chain) {
            System.out.println("Block index: " + block.index);
            System.out.println("Data: " + block.data);
            System.out.println("Previous hash: " + block.previousHash);
            System.out.println("Hash: " + block.hash);
            System.out.println();
        }
    }
}
