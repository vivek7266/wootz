package wootz;

import org.stringtemplate.v4.*;
import org.stringtemplate.v4.misc.STMessage;

import java.util.ArrayList;
import java.util.List;

public class GenerationHelper {
    protected final STGroup stGroupDir;

    protected final STGroup stGroupFile;

    private class SuppressSTErrorsListener implements STErrorListener {

        @Override
        public void compileTimeError(STMessage msg) {
            // Do nothing
        }

        @Override
        public void runTimeError(STMessage msg) {
            // Do nothing
        }

        @Override
        public void IOError(STMessage msg) {
            throw new RuntimeException(msg.toString());
        }

        @Override
        public void internalError(STMessage msg) {
            throw new RuntimeException(msg.toString());
        }
    }

    public GenerationHelper() {
        this.stGroupDir = new STGroupDir("templates");
        this.stGroupFile = new STGroupFile("templates/symbols.stg");

        SuppressSTErrorsListener errListener = new SuppressSTErrorsListener();
        stGroupDir.setListener(errListener);
        stGroupFile.setListener(errListener);
    }

    public ST getTemplate(String name) {
        ST st = stGroupDir.getInstanceOf(name);
        if (st != null) {
            return st;
        }
        return stGroupFile.getInstanceOf(name);
    }

}
