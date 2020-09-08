package strategy;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CrabCookingStrategy implements ItemListener
{
    private JFrame f;
    private JRadioButton qz,hs;
    private JPanel CenterJP,SouthJP;
    private Kitchen cf;    //厨房
    private CrabCooking qzx,hsx;    //大闸蟹加工者   
    CrabCookingStrategy()
    {
        f=new JFrame("策略模式在大闸蟹做菜中的应用");
        f.setBounds(100,100,500,400);
        f.setVisible(true);       
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SouthJP=new JPanel();
        CenterJP=new JPanel();
        f.add("South",SouthJP);
        f.add("Center",CenterJP);
        qz=new JRadioButton("清蒸大闸蟹");
        hs=new JRadioButton("红烧大闸蟹");
        qz.addItemListener(this);
        hs.addItemListener(this);
        ButtonGroup group=new ButtonGroup();
        group.add(qz);
        group.add(hs);
        SouthJP.add(qz);
        SouthJP.add(hs);
        //---------------------------------
        cf=new Kitchen();    //厨房
        qzx=new SteamedCrabs();    //清蒸大闸蟹类
        hsx=new BraisedCrabs();    //红烧大闸蟹类
    }
    public void itemStateChanged(ItemEvent e)
    {
        JRadioButton jc=(JRadioButton) e.getSource();
        if(jc==qz)
        {
            cf.setStrategy(qzx);
            cf.CookingMethod(); //清蒸
        }
        else if(jc==hs)
        {
            cf.setStrategy(hsx);
            cf.CookingMethod(); //红烧
        }
        CenterJP.removeAll();
        CenterJP.repaint();
        CenterJP.add((Component)cf.getStrategy());       
        f.setVisible(true);
    }
    public static void main(String[] args)
    {       
        new CrabCookingStrategy();
    }
}
//抽象策略类：大闸蟹加工类
interface CrabCooking
{
    public void CookingMethod();    //做菜方法
}
//具体策略类：清蒸大闸蟹
class SteamedCrabs extends JLabel implements CrabCooking
{
    private static final long serialVersionUID=1L;
    public void CookingMethod()
    {
          this.setIcon(new ImageIcon("src/strategy/SteamedCrabs.jpg"));
          this.setHorizontalAlignment(CENTER);
    }
}
//具体策略类：红烧大闸蟹
class BraisedCrabs extends JLabel implements CrabCooking
{
    private static final long serialVersionUID=1L;
    public void CookingMethod()
    {
        this.setIcon(new ImageIcon("src/strategy/BraisedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }
}
//环境类：厨房
class Kitchen
{
    private CrabCooking strategy;    //抽象策略
    public void setStrategy(CrabCooking strategy)
    {
        this.strategy=strategy;
    }
    public CrabCooking getStrategy()
    {
        return strategy;
    }
    public void CookingMethod()
    {
        strategy.CookingMethod();    //做菜   
    }
}