import java.io.*;
import java.util.*;

public class BinarySearchTree implements Serializable
{
    private class TreeNode implements Serializable
    {
        private String m_key;
        private Object m_value;
        private TreeNode m_leftChild;
        private TreeNode m_rightChild;

        public TreeNode(String inKey, Object inVal)
        {
            if(inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            m_key = inKey;
            m_value = inVal;
            m_rightChild = null;
            m_leftChild = null;
        }

        public String getKey()
        {
            return m_key;
        }

        public Object getValue()
        {
            return m_value;
        }

        public TreeNode getLeft()
        {
            return m_leftChild;
        }

        public void setLeft(TreeNode newLeft)
        {
            m_leftChild = newLeft;
        }

        public TreeNode getRight()
        {
            return m_rightChild;
        }

        public void setRight(TreeNode newRight)
        {
            m_rightChild = newRight;
        }
    }


    private TreeNode m_root;

    public BinarySearchTree()
    {
        m_root = null;
    }

    public BinarySearchTree(String inKey, Object inValue)
    {
        m_root = new TreeNode(inKey, inValue);
    }

    public Object find(String key)
    {
        return findRec(key, m_root);
    }

    private Object findRec(String key, TreeNode currNode)
    {
        Object value = null;

        if(currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }

        else if(key.equals(currNode.getKey()))
        {
            value = currNode.getValue();
        }

        else if(key.compareTo(currNode.getKey()) < 0)
        {
            value = findRec(key, currNode.getLeft());
        }

        else
        {
            value = findRec(key, currNode.getRight());
        }

        return value;
    }

    public void insert(String key, Object value)
    {
       insRec(key, value, m_root);
    }

    private TreeNode insRec(String key, Object data, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if(currNode == null)
        {
            TreeNode newNode = new TreeNode(key, data);
            updateNode = newNode;
        }
        else if(key.equals(currNode.getKey()))
        {
            throw new IllegalArgumentException("That key already exists within this tree");
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insRec(key, data, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(insRec(key, data, currNode.getRight()));
        }

        return updateNode;
    }

    public void delete(String key)
    {
        deleteRec(key, m_root);
    }

    private TreeNode deleteRec(String key, TreeNode curNode)
    {
        TreeNode updateNode = curNode;
        if(curNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }
        else if(key.equals(curNode.getKey()))
        {
            updateNode = deleteNode(key, curNode);
        }
        else if(key.compareTo(curNode.getKey()) < 0)
        {
            curNode.setLeft(deleteRec(key, curNode.getLeft()));
        }
        else
        {
            curNode.setRight(deleteRec(key, curNode.getRight()));
        }
        return updateNode;
    }

    private TreeNode deleteNode(String key, TreeNode delNode)
    {
        TreeNode updateNode = null;
        if(delNode.getLeft() == null && delNode.getRight() == null)
        {
            updateNode = null;
        }
        else if(delNode.getLeft() != null && delNode.getRight() == null)
        {
            updateNode = delNode.getLeft();
        }
        else if(delNode.getLeft() == null && delNode.getRight() != null)
        {
            updateNode = delNode.getRight();
        }
        else
        {
            updateNode = promoteSuccessor(delNode.getRight());
            if(updateNode != delNode.getRight())
            {
                updateNode.setRight(delNode.getRight());
            }
            updateNode.setLeft(delNode.getLeft());
        }
        return updateNode;
    }

    private TreeNode promoteSuccessor(TreeNode currNode)
    {
        TreeNode successor = currNode;
        if(currNode.getLeft() == null)
        {
            successor = currNode;
        }
        else
        {
            if(currNode.getLeft() != null)
            {
                successor = promoteSuccessor(currNode.getLeft());
                if(successor == currNode.getLeft())
                {
                    currNode.setLeft(successor.getRight());
                }
            }
        }
        return successor;
    }

    public int min()
    {
        return minRec(m_root);
    }

    private int minRec(TreeNode currNode)
    {
        int minKey;
        if(currNode.getLeft() != null)
        {
            minKey = minRec(currNode.getLeft());
        }
        else
        {
            minKey = Integer.parseInt(currNode.getKey());
        }

        return minKey;
    }

    public int max()
    {
        return maxRec(m_root);
    }

    private int maxRec(TreeNode currNode)
    {
        int minKey;
        if(currNode.getRight() != null)
        {
            minKey = maxRec(currNode.getRight());
        }
        else
        {
            minKey = Integer.parseInt(currNode.getKey());
        }

        return minKey;
    }

    public int height()
    {
        return heightRec(m_root);
    }

    public int height(TreeNode node)
    {
        return heightRec(node);
    }

    private int heightRec(TreeNode currNode)
    {
        int htSoFar, iLeftHt, iRightHt;
        
        if(currNode == null)
        {
            htSoFar = -1;
        }
        else
        {
           iLeftHt = heightRec(currNode.getLeft());
           iRightHt = heightRec(currNode.getRight());
           
           // Get highest of left vs right branches
           if(iLeftHt > iRightHt)
           {
            htSoFar =  iLeftHt + 1;
           }
           else
           {
            htSoFar = iRightHt + 1;
           }
        }
        return htSoFar;
    }
    
    public double balance()
    {
        TreeNode lNode = m_root.getLeft();
        TreeNode rNode = m_root.getRight();
        int lHeight, rHeight;
        double balance;
        lHeight = height(lNode);
        rHeight = height(rNode);
        if(lHeight <= rHeight)
        {
            balance = 100 * (Double.valueOf(lHeight)) / (Double.valueOf(rHeight));
        }
        else
        {
            balance = 100 * (Double.valueOf(rHeight)) / (Double.valueOf(lHeight));
        }
        return balance;
    }

    public void inOrderTraverse()
    {
        inOrderRec(m_root);
    }

    private void inOrderRec(TreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        else
        {
            inOrderRec(currNode.getLeft());
            System.out.println(currNode.getKey());
            inOrderRec(currNode.getRight());
        }
    }

    public void preOrderTraverse()
    {
        preOrderRec(m_root);
    }

    private void preOrderRec(TreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        else
        {
            System.out.println(currNode.getKey());
            preOrderRec(currNode.getLeft());
            preOrderRec(currNode.getRight());
        }
    }

    public void postOrderTraverse()
    {
        postOrderRec(m_root);
    }

    private void postOrderRec(TreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        else
        {
            postOrderRec(currNode.getLeft());
            postOrderRec(currNode.getRight());
            System.out.println(currNode.getKey());
        }
    }

    public void save(BinarySearchTree objToSave, String filename)
	{
		FileOutputStream fileStrm;
		ObjectOutputStream objStrm;

		try
		{
			fileStrm = new FileOutputStream(filename);
			objStrm = new ObjectOutputStream(fileStrm);
			objStrm.writeObject(objToSave);

			objStrm.close();
		} catch(Exception e){
			throw new IllegalArgumentException("Unable to save object to file");
		}
	}

	public BinarySearchTree load(String filename) throws IllegalArgumentException
	{
		FileInputStream fileStrm;
 		ObjectInputStream objStrm;
 		BinarySearchTree inObj = null;
		try {
		fileStrm = new FileInputStream(filename);
		objStrm = new ObjectInputStream(fileStrm); 
		inObj = (BinarySearchTree)objStrm.readObject(); 
		objStrm.close();
		}
		catch (ClassNotFoundException e) {
		System.out.println("Class ContainerClass not found" + e.getMessage());
		}
		catch (Exception e) {
		throw new IllegalArgumentException("Unable to load object from file");
		}
		return inObj;
	}
}