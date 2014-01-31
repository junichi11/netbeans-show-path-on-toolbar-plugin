/*
 * The MIT License
 *
 * Copyright 2014 junichi11.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.junichi11.netbeans.showpath.ui.actions;

import com.junichi11.netbeans.showpath.ui.ShowPathPanel;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;

@ActionID(category = "Edit", id = "com.junichi11.netbeans.showpath.ui.actions.CopyPathAction")
@ActionRegistration(lazy = false, displayName = "#CTL_CopyPathAction")
@NbBundle.Messages("CTL_CopyPathAction=Copy path to clipboard")
/**
 *
 * @author junichi11
 */
public class CopyPathAction extends AbstractAction {

    private static final long serialVersionUID = 2213029540878314874L;

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();

        // get full path
        ShowPathPanel showPathPanel = ShowPathPanel.getInstance();
        String fullPath = showPathPanel.getFullPath();
        if (fullPath.isEmpty()) {
            return;
        }

        // set full path to clipboard
        StringSelection stringSelection = new StringSelection(fullPath);
        clipboard.setContents(stringSelection, stringSelection);
    }

}
