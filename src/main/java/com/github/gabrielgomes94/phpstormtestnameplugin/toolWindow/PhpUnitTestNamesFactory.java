package com.github.gabrielgomes94.phpstormtestnameplugin.toolWindow;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class PhpUnitTestNamesFactory implements ToolWindowFactory, DumbAware {
    @Override
    public void createToolWindowContent(
            @NotNull Project project,
            @NotNull ToolWindow toolWindow
    ) {
        PhpUnitTestNamesToolWindowContent toolWindowContent = new PhpUnitTestNamesToolWindowContent(toolWindow);
        Content content = ContentFactory.getInstance().createContent(
                toolWindowContent.getContentPanel(), "", false
        );

        toolWindow.getContentManager().addContent(content);
    }

    private static class PhpUnitTestNamesToolWindowContent
    {
        private final JPanel contentPanel = new JPanel();

        public PhpUnitTestNamesToolWindowContent(ToolWindow toolWindow)
        {
            contentPanel.setLayout(new BorderLayout(0, 20));
            contentPanel.setBorder(
                    BorderFactory.createEmptyBorder(40, 0, 0, 0)
            );
        }

        public JPanel getContentPanel() {
            return contentPanel;
        }
    }
}
