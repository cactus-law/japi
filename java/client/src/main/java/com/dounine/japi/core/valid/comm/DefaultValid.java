package com.dounine.japi.core.valid.comm;

import com.dounine.japi.common.JapiPattern;
import com.dounine.japi.core.IParameter;
import com.dounine.japi.core.impl.BuiltInJavaImpl;
import com.dounine.japi.core.impl.ParameterImpl;
import com.dounine.japi.serial.request.RequestImpl;
import com.dounine.japi.core.valid.IMVC;
import com.dounine.japi.core.valid.IValid;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lake on 17-2-20.
 */
public class DefaultValid implements IValid {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultValid.class);

    private String javaFilePath;

    @Override
    public List<IMVC> getTypes() {
        return null;
    }

    @Override
    public IParameter getParameter(String parameterStr, List<String> docsStrs) {
        ParameterImpl parameter = new ParameterImpl();
        String[] typeAndName = parameterStr.split(StringUtils.SPACE);
        if (BuiltInJavaImpl.getInstance().isBuiltInType(typeAndName[0])) {
            List<RequestImpl> requestFields = new ArrayList<>();
            RequestImpl requestField = new RequestImpl();
            requestField.setName(typeAndName[1]);
            requestField.setRequired(false);
            String description = "";
            if (null != docsStrs && docsStrs.size() > 0) {
                for (String doc : docsStrs) {
                    Pattern pattern = JapiPattern.getPattern("[*]\\s*[@]\\S*\\s*" + typeAndName[1]);//找到action传进来的注解信息
                    Matcher matcher = pattern.matcher(doc);
                    if (matcher.find()) {
                        description = doc.substring(matcher.end()).trim();
                        break;
                    }
                }
            }
            requestField.setDescription(description);
            requestField.setDefaultValue("");
            requestField.setType(typeAndName[0]);
            requestFields.add(requestField);
            parameter.setRequestFields(requestFields);
        } else {
            LOGGER.warn("对象类型宝宝表示还没有开始支持呢");
        }
        return parameter;
    }


    public String getJavaFilePath() {
        return javaFilePath;
    }

    public void setJavaFilePath(String javaFilePath) {
        this.javaFilePath = javaFilePath;
    }

}
