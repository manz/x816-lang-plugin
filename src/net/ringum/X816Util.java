package net.ringum;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import net.ringum.psi.X816LabelDef;
import net.ringum.psi.X816NamedElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class X816Util {
    public static List<X816NamedElement> findLabelOrSymbolDef(Project project, String key) {
        List<X816NamedElement> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, X816FileType.INSTANCE,
                GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            X816File x816File = (X816File) PsiManager.getInstance(project).findFile(virtualFile);
            if (x816File != null) {
                Collection<X816NamedElement> labelDefs = PsiTreeUtil.findChildrenOfType(x816File, X816NamedElement.class);
                if (!labelDefs.isEmpty()) {
                    for (X816NamedElement labelDef : labelDefs) {
                        if (key != null) {
                            if (key.equals(labelDef.getName())) {
                                if (result == null) {
                                    result = new ArrayList<X816NamedElement>();
                                }
                                result.add(labelDef);
                            }
                        } else {
                            if (result == null) {
                                result = new ArrayList<X816NamedElement>();
                            }
                            result.add(labelDef);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<X816NamedElement>emptyList();

    }

    public static List<X816LabelDef> findLabelsDef(Project project, String key) {
        List<X816LabelDef> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, X816FileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            X816File x816File = (X816File) PsiManager.getInstance(project).findFile(virtualFile);
            if (x816File != null) {
                Collection<X816LabelDef> labelDefs = PsiTreeUtil.findChildrenOfType(x816File, X816LabelDef.class);
                if (!labelDefs.isEmpty()) {
                    for (X816LabelDef labelDef : labelDefs) {
                        if (key != null) {
                            if (key.equals(labelDef.getName())) {
                                if (result == null) {
                                    result = new ArrayList<X816LabelDef>();
                                }
                                result.add(labelDef);
                            }
                        } else {
                            if (result == null) {
                                result = new ArrayList<X816LabelDef>();
                            }
                            result.add(labelDef);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<X816LabelDef>emptyList();
    }
}
