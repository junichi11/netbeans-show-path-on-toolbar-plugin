/*
 * The MIT License
 *
 * Copyright 2015 trashtoy.
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
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(category = "Edit", id = "com.junichi11.netbeans.showpath.ui.actions.OpenPathAction")
@ActionRegistration(displayName = "#CTL_OpenPathAction")
@Messages("CTL_OpenPathAction=Open path with associated program")
public final class OpenPathAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // get full path
        ShowPathPanel showPathPanel = ShowPathPanel.getInstance();
        String fullPath = showPathPanel.getFullPath();
        if (fullPath.isEmpty()) {
            return;
        }

        final Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            desktop.open(new File(fullPath));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
