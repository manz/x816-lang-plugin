package net.ringum;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import net.ringum.psi.X816NamedElement;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class X816ChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<X816NamedElement> labelsDef = X816Util.findLabelOrSymbolDef(project, null);
        List<String> names = new ArrayList<String>(labelsDef.size());
        for (X816NamedElement labelDef : labelsDef) {
            if (labelDef.getName() != null && labelDef.getName().length() > 0) {
                names.add(labelDef.getName());
            }
        }
        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        List<X816NamedElement> labelsDef = X816Util.findLabelOrSymbolDef(project, name);
        return labelsDef.toArray(new NavigationItem[labelsDef.size()]);
    }
}
