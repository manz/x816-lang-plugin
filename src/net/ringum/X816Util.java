package net.ringum;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import net.ringum.psi.X816NamedElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class X816Util {
    public static List<X816NamedElement> findLabelOrSymbolDef(Project project, String key) {

        String parentKey;
        String childrenKey;
        List<X816NamedElement> result = null;

        if (key != null) {
            if (key.contains(".")) {
                parentKey = key.split("\\.")[0];
                childrenKey = key.split("\\.")[1];
            } else {
                parentKey = key;
            }

            Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME,
                    X816FileType.INSTANCE,
                    GlobalSearchScope.allScope(project));

            for (VirtualFile virtualFile : virtualFiles) {
                X816File x816File = (X816File) PsiManager.getInstance(project).findFile(virtualFile);
                if (x816File != null) {
                    Collection<X816NamedElement> namedElements = PsiTreeUtil.findChildrenOfType(x816File, X816NamedElement.class);
                    if (!namedElements.isEmpty()) {
                        for (X816NamedElement namedElement : namedElements) {
                            if (parentKey.equals(namedElement.getName())) {
                                if (result == null) {
                                    result = new ArrayList<X816NamedElement>();
                                }
                                result.add(namedElement);
                            }
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<X816NamedElement>emptyList();

    }

}
