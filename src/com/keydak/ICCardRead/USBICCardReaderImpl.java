package com.keydak.ICCardRead;

import com.syc.function.Function;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;

/**
 * Created by Caisz on 2016/11/28.
 */
public class USBICCardReaderImpl implements USBICCardReader{



    public static final void main(String[] args) {
        USBICCardReader usbicCardReader = new USBICCardReaderImpl();
        System.out.println("####" + usbicCardReader.readICCard() );
    }

    @Override
    public String readICCard() {
        byte mode,halt;
        boolean snrIdleIsSelected = true;
        boolean snrHaltIsSelected = true;

        if (snrIdleIsSelected)
        {
            mode = 0x26;
        }
        else
        {
            mode = 0x52;
        }
        if(snrHaltIsSelected)
        {
            halt = 0x00;
        }
        else
        {
            halt = 0x01;
        }
        Pointer p = null ;
        try {
            p = new Pointer(MemoryBlockFactory.createMemoryBlock(256));
        } catch (NativeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Pointer v = null ;
        try {
            v = new Pointer(MemoryBlockFactory.createMemoryBlock(256));
        } catch (NativeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        int ret = Function.MF_Getsnr(mode, halt, p, v);
        if ( ret == 0)
        {
            System.out.println("success\n");
            if(Function.byte0 == 0)
            {
                System.out.println("It is only one card...\n");
            }
            else
            {
                System.out.println("It is more than one card...\n");
            }
            System.out.println("Card Number:\n");
            StringBuffer icCardId = new StringBuffer();
            for ( int i = 0 ; i < 4 ; i ++)
            {
                try {
                    icCardId.append(String.format("%02X", Function.b.getAsByte(i)));
                    System.out.println(String.format("%02X", Function.b.getAsByte(i))+" ");
                } catch (NativeException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            System.out.println("\n\n");
            return icCardId.toString();
        }
        else
        {
            System.out.println("false\n");
            Function.falsereason(Integer.toString(ret));
            System.out.println(Function.reason);
            Function.falsereason(String.format("%02X", Function.byte0));
            System.out.println(Function.reason+"\n\n");
            Function.reason = "";
        }
        return null;
    }

    @Override
    public String readICCard(boolean snrIdle, boolean snrHalt) {
        byte mode,halt;
        boolean snrIdleIsSelected = snrIdle;
        boolean snrHaltIsSelected = snrHalt;

        if (snrIdleIsSelected)
        {
            mode = 0x26;
        }
        else
        {
            mode = 0x52;
        }
        if(snrHaltIsSelected)
        {
            halt = 0x00;
        }
        else
        {
            halt = 0x01;
        }
        Pointer p = null ;
        try {
            p = new Pointer(MemoryBlockFactory.createMemoryBlock(256));
        } catch (NativeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Pointer v = null ;
        try {
            v = new Pointer(MemoryBlockFactory.createMemoryBlock(256));
        } catch (NativeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        int ret = Function.MF_Getsnr(mode, halt, p, v);
        if ( ret == 0)
        {
            System.out.println("success\n");
            if(Function.byte0 == 0)
            {
                System.out.println("It is only one card...\n");
            }
            else
            {
                System.out.println("It is more than one card...\n");
            }
            System.out.println("Card Number:\n");
            StringBuffer icCardId = new StringBuffer();
            for ( int i = 0 ; i < 4 ; i ++)
            {
                try {
                    icCardId.append(String.format("%02X", Function.b.getAsByte(i)));
                    System.out.println(String.format("%02X", Function.b.getAsByte(i))+" ");
                } catch (NativeException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            System.out.println("\n\n");
            return icCardId.toString();
        }
        else
        {
            System.out.println("false\n");
            Function.falsereason(Integer.toString(ret));
            System.out.println(Function.reason);
            Function.falsereason(String.format("%02X", Function.byte0));
            System.out.println(Function.reason+"\n\n");
            Function.reason = "";
        }
        return null;
    }
}
