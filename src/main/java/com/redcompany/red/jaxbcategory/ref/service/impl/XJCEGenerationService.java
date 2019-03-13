package com.redcompany.red.jaxbcategory.ref.service.impl;

import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.service.XMLService;
import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import org.xml.sax.InputSource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

import static com.redcompany.red.jaxbcategory.ref.service.impl.util.ServiceConstantStorage.*;

public class XJCEGenerationService implements XMLService {

    private static final XJCEGenerationService instance = new XJCEGenerationService();

    @Override
    public boolean doService(RequestParam param) {
        if (checkFile(CHECK_FILE)== false){
            try {
                generateFromSchema(new File(SCHEMA_FILE), ENTITY_PACKAGE_NAME, new File(TARGET_PATH));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFile (String filePath){
        if ((new File(filePath)).isFile()) {
            return true;
        } else {
          return false;
        }
    }


    public JCodeModel generateFromSchema(final File schemaFile, final String packageName,
                                         final File targetPath) throws Exception {
        final SchemaCompiler sc = XJC.createSchemaCompiler();
        final FileInputStream schemaStream = new FileInputStream(schemaFile);
        final InputSource is = new InputSource(schemaStream);
        is.setSystemId(schemaFile.toURI().toString());
        sc.parseSchema(is);
        sc.forcePackageName(packageName);
        final S2JJAXBModel s2 = sc.bind();
        final JCodeModel jcm = s2.generateCode(null, null);
        try (PrintStream status = new PrintStream(new ByteArrayOutputStream())) {
            jcm.build(targetPath, status);
        }
        return jcm;
    }


    public static XJCEGenerationService getInstance() {
        return instance;
    }

}
