package com.bluecattle.web.util;

import com.bluecattle.web.config.jade4j.JadeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@JadeHelper("util")
public class UtilJade {

    @Autowired
    private MessageSource messageSource;

    public String message(String code) {
        return messageSource.getMessage(code, null,
                String.format("not found: %s", code),
                getLocale());
    }

    public String formatNumber(BigDecimal number, String format) {
        DecimalFormatSymbols dcfs = new DecimalFormatSymbols();
        DecimalFormat decimalFormat = new DecimalFormat(format, dcfs);
        decimalFormat.setParseBigDecimal(true);
        return decimalFormat.format(number);
    }
}
