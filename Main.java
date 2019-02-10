package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.Node;
import com.jme3.math.ColorRGBA;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import java.util.Random;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    
    // Protected items
    protected Geometry cube1;
    protected Geometry cube2;
    protected Geometry cube3;
    protected Geometry cube4;
    protected Geometry sphere;
    protected Node sphereNode;
   
    // Variables to be edited
    private boolean cubeRotate = false;
    private boolean sphereOn = false;
    
    private float sphereSpeed = 0.5f;

    @Override
    public void simpleInitApp() {
        
        // Create all objects for the scene
        
        // Create nodes
        Node cubeNode = new Node("cubeNode");
        sphereNode = new Node("sphereNode");
        
        rootNode.attachChild(cubeNode);
        rootNode.attachChild(sphereNode);
        
        // Create the cubes
        Box cube = new Box(1,1,1);
        cube1 = new Geometry("Box", cube);
        cube2 = new Geometry("Box", cube);
        cube3 = new Geometry("Box", cube);
        cube4 = new Geometry("Box", cube);
        Material cubeMat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        cubeMat.setColor("Color", ColorRGBA.Blue);
        cube1.setMaterial(cubeMat);
        cube2.setMaterial(cubeMat);
        cube3.setMaterial(cubeMat);
        cube4.setMaterial(cubeMat);
        cube1.setLocalTranslation(new Vector3f(1,1,1));
        cube2.setLocalTranslation(new Vector3f(5,1,1));
        cube3.setLocalTranslation(new Vector3f(1,1,5));
        cube4.setLocalTranslation(new Vector3f(5,1,5));
        cubeNode.attachChild(cube1);
        cubeNode.attachChild(cube2);
        cubeNode.attachChild(cube3);
        cubeNode.attachChild(cube4);
        
        // Create the sphere
        Sphere ball = new Sphere(3,3,3);
        sphere = new Geometry("Sphere", ball);
        Material ballMat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        ballMat.setColor("Color", ColorRGBA.Red);
        sphere.setMaterial(ballMat);
        sphereNode.attachChild(sphere);
        sphere.setLocalTranslation(new Vector3f(10,1,1));
        
        // Create the text
        guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText botTxt = new BitmapText(guiFont, false);
        botTxt.setSize(guiFont.getCharSet().getRenderedSize());
        botTxt.setText("1=Cube Color, 2=Sphere Speed, 3=Cube Rotate");
        botTxt.setLocalTranslation(250, botTxt.getLineHeight(), 0);
        guiNode.attachChild(botTxt);
        
        initKeys();
    }
    
    /* Use the main event loop to trigger repeating actions. */
    @Override
    public void simpleUpdate(float tpf) {
        
        // Check for the cuteRotate variable, if true rotate all the cubes
        if (cubeRotate) {
            cube1.rotate(0, 2*tpf, 0);
            cube2.rotate(0, 2*tpf, 0);
            cube3.rotate(0, 2*tpf, 0);
            cube4.rotate(0, 2*tpf, 0);
        }
        
        // Constant rotate of the sphereNode, making the sphere go around the entire scene
        sphereNode.rotate(0,sphereSpeed*tpf, 0);
    }
    
    private void initKeys() {
        // Mapping the 1-3 into the game
        inputManager.addMapping("1",  new KeyTrigger(KeyInput.KEY_1));  // Change the cubes to random color
        inputManager.addMapping("2",   new KeyTrigger(KeyInput.KEY_2)); // Toggle on/off spehres speed
        inputManager.addMapping("3",  new KeyTrigger(KeyInput.KEY_3));  // Toggle on/off cube rotation
        
        // Adding listeners for the keys
        inputManager.addListener(actionListener, "1");
        inputManager.addListener(actionListener, "2");
        inputManager.addListener(actionListener, "3");
    }
    
    // Handles the actions that occur when the key is pressed
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            
            // If the key pressed was 1
            if (name.equals("1") && !keyPressed) {
                
                // Random 1-10
                Random rand = new Random();

                int randomNum = rand.nextInt((10 - 1) + 1) + 1;
                
                Material newMat = new Material(assetManager, 
                        "Common/MatDefs/Misc/Unshaded.j3md");
                
                // Change the material of the cubes according to the number from the random
                switch (randomNum) {
                    case 1:
                        newMat.setColor("Color", ColorRGBA.Blue);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 2:
                        newMat.setColor("Color", ColorRGBA.Brown);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 3:
                        newMat.setColor("Color", ColorRGBA.Cyan);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 4:
                        newMat.setColor("Color", ColorRGBA.Gray);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 5:
                        newMat.setColor("Color", ColorRGBA.Green);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 6:
                        newMat.setColor("Color", ColorRGBA.Magenta);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 7:
                        newMat.setColor("Color", ColorRGBA.Orange);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 8:
                        newMat.setColor("Color", ColorRGBA.Pink);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 9:
                        newMat.setColor("Color", ColorRGBA.White);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    case 10:
                        newMat.setColor("Color", ColorRGBA.Yellow);
                        cube1.setMaterial(newMat);
                        cube2.setMaterial(newMat);
                        cube3.setMaterial(newMat);
                        cube4.setMaterial(newMat);
                        break;
                    default:
                        break;
                }
            }
            
            // If 2nd key pressed, speed or slow down the sphere
            if (name.equals("2") && !keyPressed) {
                sphereOn = !sphereOn;
                
                if (sphereOn) {
                    sphereSpeed = 2f;
                } else {
                    sphereSpeed = 0.5f;
                }
            }
            
            // If 3 key was pressed, toggle the cubeRotate variable
            if (name.equals("3") && !keyPressed) {
                cubeRotate = !cubeRotate;
            }
        }
    };
}