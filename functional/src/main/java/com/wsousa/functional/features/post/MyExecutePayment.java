package com.wsousa.functional.features.post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyExecutePayment {
    public static void main(String[] args) {
        Receipt receipt = new Receipt("Evening gown", 500.00, 0.05, 0.07);
        simpleReceiptPrinter.print(receipt);
        exemptReceiptPrinter.print(receipt);

        IntegerProcessor anonNumberProcess = new IntegerProcessor() {
            @Override
            public Integer process(Integer x)
            {
                return x * x;
            }
        };

        log.info(" {}",anonNumberProcess.process(10));
    }

    static Payment simpleReceiptPrinter = new Payment() {
        @Override
        public void print(Receipt receipt) {
            log.info("Item :\t" + receipt.item);
            log.info("Price:\t"+ receipt.price);
            log.info("Disc:\t" + receipt.discount);
            log.info("Tax:\t"+ receipt.tax );
            log.info("Total:\t"+ computeTotal(receipt));
        }
    };

    static Payment exemptReceiptPrinter = new Payment() {
        @Override
        public void print(Receipt receipt)
        {
            log.info("Item :\t" + receipt.item);
            log.info("Price:\t"   + receipt.price);
            log.info("Disc:\t"    + receipt.discount);
            log.info("Total:\t"   + computeTotal(receipt));
        }
        @Override
        public double computeTotal(Receipt receipt) {
            return receipt.price - (receipt.price * receipt.discount);
        }
    };

}
