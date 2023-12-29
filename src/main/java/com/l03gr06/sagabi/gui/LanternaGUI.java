package com.l03gr06.sagabi.gui;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l03gr06.sagabi.factories.ReadFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings({"Immutable","JavaLangClash", "ObjectToString"})
public class LanternaGUI implements GUI{


    HashMap<String, Character> mapMonsterInfo; //maybe change to string
    HashMap<String, Character> mapDecorationsInfo;
    HashMap<String,String> colors;

    HashMap<Character, TextImage> letterTextImages;
    HashMap<String, TextImage> leanMenuImageTextImages;
    HashMap<String, TextImage> battlerTextImages;
    final int letterImageSize = 2;

    private void loadBattlerTextImages(String path)
    {
        battlerTextImages= new HashMap<>();
        ReadFile reader= new ReadFile(path);
        List<String> lines= reader.splitInLines();

        int i=0;
        while(i<lines.size())
        {
            String l1=lines.get(i);
            String[] l1Splt=l1.split(" ");
            int x=Integer.parseInt(l1Splt[1]);
            int y=Integer.parseInt(l1Splt[2]);

            TextImage img= new BasicTextImage(x,y);
            TextGraphics grphcs= img.newTextGraphics();
            i++;
            for (int Y=0;Y<y&&i<lines.size();Y++)
            {
                String l=lines.get(i);
                for (int X=0;X<Math.min(x,l.length());X++)
                {
                    drawCharacter(X,Y,l.charAt(X),colors.get("white"),grphcs);
                }
                i++;
            }
            battlerTextImages.put(l1Splt[0],img);
            if (i<lines.size())
            {
                if (lines.get(i).strip().equals("//"))
                {
                    i++;
                }
            }

        }

    }

    public Map<String, Character> getMapMonsterInfo() {
        return mapMonsterInfo;
    }

    public Map<String, Character> getMapDecorationsInfo() {
        return mapDecorationsInfo;
    }

    public Map<Character, TextImage> getLetterTextImages() {
        return letterTextImages;
    }
    public Map<String, TextImage> getBattlerTextImages() {
        return battlerTextImages;
    }

    public Map<String, TextImage> getLeanMenuImageTextImages() {
        return leanMenuImageTextImages;
    }

    private void initColors(String colorPath)
{
    colors= new HashMap<>();

    ReadFile file = new ReadFile(colorPath);
    List<String> lines=file.splitInLines();
    for (String line:lines)
    {
        String[] splt=line.split(" ");
        colors.put(splt[0],splt[1]);
    }

}
    private void initInfo(String colorPath,String monsterImagePath)
    {
initColors(colorPath);
        loadBattlerTextImages(monsterImagePath);

        mapMonsterInfo= new HashMap<>();
        mapMonsterInfo.put("round_monster",'\u0024');
        mapDecorationsInfo= new HashMap<>();
        mapDecorationsInfo.put("wall",'~');

        mapDecorationsInfo.put("tree1", '}');

        mapDecorationsInfo.put("tree2",'[');

        mapDecorationsInfo.put("weird", ']');

        letterTextImages= new HashMap<>();

        letterTextImages.put(' ',new BasicTextImage(2, letterImageSize));

        TextImage image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.A,"white",image.newTextGraphics());
        letterTextImages.put('A',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.B,"white",image.newTextGraphics());
        letterTextImages.put('B',image);


        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.C,"white",image.newTextGraphics());
        letterTextImages.put('C',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.D,"white",image.newTextGraphics());
        letterTextImages.put('D',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.E,"white",image.newTextGraphics());
        letterTextImages.put('E',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.F,"white",image.newTextGraphics());
        letterTextImages.put('F',image);


        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.G,"white",image.newTextGraphics());
        letterTextImages.put('G',image);


        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.H,"white",image.newTextGraphics());
        letterTextImages.put('H',image);


        image= new BasicTextImage(1,2);
        drawString(0,0,BigLetters.I,"white",image.newTextGraphics());
        letterTextImages.put('I',image);

        image= new BasicTextImage(1,2);
        drawString(0,0,BigLetters.J,"white",image.newTextGraphics());
        letterTextImages.put('J',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.K,"white",image.newTextGraphics());
        letterTextImages.put('K',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.L,"white",image.newTextGraphics());
        letterTextImages.put('L',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.M,"white",image.newTextGraphics());
        letterTextImages.put('M',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.N,"white",image.newTextGraphics());
        letterTextImages.put('N',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.O,"white",image.newTextGraphics());
        letterTextImages.put('O',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.P,"white",image.newTextGraphics());
        letterTextImages.put('P',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.Q,"white",image.newTextGraphics());
        letterTextImages.put('Q',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.R,"white",image.newTextGraphics());
        letterTextImages.put('R',image);

        image= new BasicTextImage(1,2);
        drawString(0,0,BigLetters.S,"white",image.newTextGraphics());
        letterTextImages.put('S',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.T,"white",image.newTextGraphics());
        letterTextImages.put('T',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.U,"white",image.newTextGraphics());
        letterTextImages.put('U',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.V,"white",image.newTextGraphics());
        letterTextImages.put('V',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.W,"white",image.newTextGraphics());
        letterTextImages.put('W',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.X,"white",image.newTextGraphics());
        letterTextImages.put('X',image);

        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.Y,"white",image.newTextGraphics());
        letterTextImages.put('Y',image);


        image= new BasicTextImage(2,2);
        drawString(0,0,BigLetters.Z,"white",image.newTextGraphics());
        letterTextImages.put('Z',image);

        image= new BasicTextImage(3,6);
        drawString(0,0,BigLetters.dot,"white",image.newTextGraphics());
        letterTextImages.put('.',image);


        image= new BasicTextImage(3,6);
        drawString(0,0,BigLetters.exclamation,"white",image.newTextGraphics());
        letterTextImages.put('!',image);


        image= new BasicTextImage(6,6);
        drawString(0,0,BigLetters.question,"white",image.newTextGraphics());
        letterTextImages.put('?',image);
    }



    private final Screen screen;
    private final TextGraphics graphics;

    public LanternaGUI(int width, int height,String colorPath,String monsterImagePath) throws IOException, FontFormatException, URISyntaxException, NullPointerException
    {
        AWTTerminalFontConfiguration fontConfig;
        {
            URL resource = getClass().getClassLoader().getResource("graphics/Font.ttf");
            URI file= resource.toURI();
            File fontFile = new File(file);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            Font loadedFont = font.deriveFont(Font.PLAIN, 30);
            //Font loadedFont2 = font.deriveFont(Font.PLAIN, 20);
            fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);


        }


        Terminal terminal;
        {
            TerminalSize terminalSize = new TerminalSize(width, height + 1);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            terminalFactory.setForceAWTOverSwing(true);
            terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
            terminal = terminalFactory.createTerminal();
        }

        {
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        }
        graphics = screen.newTextGraphics();

        initInfo(colorPath,monsterImagePath);
    }
    //Parameter constructor for testing purposes

    public LanternaGUI(int width, int height, TextGraphics graphics, String colorPath, Screen screen,String monsterImagePath) {
        this.graphics = graphics;
        this.screen = screen;
        initInfo(colorPath,monsterImagePath);
    }
    private void drawCharacter(int x, int y, char c, String color, TextGraphics graphics) {
        TextColor textColor = TextColor.Factory.fromString(color);
        if (textColor == null) {
            throw new IllegalArgumentException("Invalid color string");
        }
        graphics.setForegroundColor(textColor);
        graphics.setCharacter(x, y, c);
    }
    
    protected void drawString(int x, int y, String c, String color, TextGraphics graphics) {
        TextColor textColor = TextColor.Factory.fromString(color);
        if (textColor == null) {
            throw new IllegalArgumentException("Invalid color string");
        }
        graphics.setForegroundColor(textColor);
        String[] smthng = c.split("\n");
        for (int i = 0; i < smthng.length; i++) {
            graphics.putString(x, y + i, smthng[i]);
        }
    }
    @Override
    public void drawPlayer(int x, int y) {
        drawCharacter(x,y,'&',colors.get("white"),graphics);
    }

    @Override
    public void drawMonster(int x, int y, String id,String color) {
        Character info;
        if (mapMonsterInfo.containsKey(id))
        {
            info = mapMonsterInfo.get(id);
        }else
        {
            info= '0';
        }
        drawCharacter(x,y, info,colors.get(color),graphics);
    }

    @Override
    public void drawObstacle(int x, int y, String id,String color) {
        Character info;
        if (mapDecorationsInfo.containsKey(id))
        {
            info= mapDecorationsInfo.get(id);
        }else
        {
            info= '#';
        }
        drawCharacter(x,y, info,colors.get(color),graphics);
    }

    @Override
    public void drawHealSpot(int x, int y) {
        drawCharacter(x,y,'#',colors.get("white"),graphics);
    }

    @Override
    public void drawStringNormal(int x, int y, String string,String color) {
        drawString(x,y,string,colors.get(color),graphics);
    }


    @Override
    public void drawStringBig(int x, int y, String string) {
        int X=0;
        int Y=0;
        for(int i =0;i<string.length();i++)
        {

            Character chr=string.charAt(i);
            if (chr.equals('\n'))
            {
                Y+=letterImageSize;
                X=0;
                continue;
            }
            TextImage img;
            chr=Character.toUpperCase(string.charAt(i));
            if (letterTextImages.containsKey(chr))
            {
                img= letterTextImages.get(chr);
            }else{
                img = letterTextImages.get('?');
            }

            graphics.drawImage(new TerminalPosition(x+X,Y+y),img);
            X+= img.getSize().getColumns()+2;

        }
    }

    @Override
    public void drawBox(int x, int y, int w, int h) {
        for (int i=1;i<w-1;i++)
    {
        drawCharacter(x+i,y,'_',colors.get("white"),graphics);
    }
    for (int i=1;i<w-1;i++)
    {
            drawCharacter(x+i,y+h-1,'_',colors.get("white"),graphics);
    }
    for (int i=1;i<h;i++)
    {
            drawCharacter(x,y+i,'|',colors.get("white"),graphics);
    }

    for (int i=1;i<h;i++)
    {
            drawCharacter(x+w-1,y+i,'|',colors.get("white"),graphics);
    }

    }
    @Override
    public void clear() {

        screen.clear();
    }

    @Override
    public void drawPlayerInBattle(int x, int y) {
         if (battlerTextImages.containsKey("Sagabi")) {
            graphics.drawImage(new TerminalPosition(x, y), battlerTextImages.get("Sagabi"));
            }
         else
            {
                drawStringBig(x,y,"?");
            }
    }

    @Override
    public void drawEnemyInBattle(int x, int y,String id) {
         if (battlerTextImages.containsKey(id)) {
            graphics.drawImage(new TerminalPosition(x, y), battlerTextImages.get(id));
        }
        else
        {
            drawStringBig(x,y,"?");
        }
    }
    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public Action getNextAction() throws IOException
    {
        KeyStroke keyStroke = screen.pollInput();

        while (screen.pollInput() != null) {}

        if (keyStroke == null) {return Action.NONE;}
        KeyType type = keyStroke.getKeyType();

        if (type == KeyType.EOF)
        {return Action.QUIT;}
        if (type == KeyType.Character)
        {
            if(keyStroke.getCharacter() == 'q')
            {return Action.QUIT;}
            if(keyStroke.getCharacter() == 'x')
            {return Action.SELECT;}
        }
        if (type==KeyType.Escape)
        {
            {return Action.QUIT;}
        }

        if (type == KeyType.ArrowUp) {return Action.UP;}
        if (type == KeyType.ArrowRight) {return Action.RIGHT;}
        if (type == KeyType.ArrowDown) {return Action.DOWN;}
        if (type== KeyType.ArrowLeft) {return Action.LEFT;}

        if (type == KeyType.Enter) {return Action.SELECT;}



        return Action.NONE;
    }
    @Override
    public void close()throws IOException
    {
        screen.close();
    }

    @Override
    public void drawOpenDoor(int x,int y,String color)
    {
        drawCharacter(x,y,'%',colors.get(color),graphics);
    }
    @Override
    public void drawClosedDoor(int x,int y,String color)
    {
        drawCharacter(x,y,'\"',colors.get(color),graphics);
    }


}
