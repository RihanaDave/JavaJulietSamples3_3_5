/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__Environment_01.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-01.tmpl.java
*/
/*
* @description
* CWE: 36 Absolute Path Traversal
* BadSource: Environment Read a string from an environment variable
* GoodSource: A hardcoded string
* BadSink: readFile read line from file from disk
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE36_Absolute_Path_Traversal__Environment_01 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        File fIn = new File(data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - uses goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        File fIn = new File(data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

