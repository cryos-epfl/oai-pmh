package ch.epfl.osper.oai.rest.verbs;

import ch.epfl.osper.oai.interfaces.MetadataFormat;
import ch.epfl.osper.oai.interfaces.MetadataFormats;
import ch.epfl.osper.oai.rest.ErrorOai;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

/**
 * Created by kryvych on 04/09/15.
 */
@Named
@Scope("prototype")
public class ListMetadataFormats {

    protected static final Logger logger = LoggerFactory.getLogger(Identify.class);
    protected final MetadataFormats metadataFormats;

    private final TemplateHelper templateHelper;

    @Inject
    public ListMetadataFormats(MetadataFormats metadataFormats, TemplateHelper templateHelper) {
        this.metadataFormats = metadataFormats;
        this.templateHelper = templateHelper;
    }


    public String getResponse() {
        StringBuilder formats = new StringBuilder();
        if (metadataFormats.getFormats().isEmpty()) {
            return ErrorOai.NO_METADATA_FORMATS.generateMessage(templateHelper, "ListMetadataFormats", "");
        }
        for (MetadataFormat metadataFormat : metadataFormats.getFormats()) {
            Map<String, String> parameters = Maps.newHashMap();
            parameters.put("prefix", metadataFormat.getName());
            parameters.put("schema", metadataFormat.getSchema());
            parameters.put("namespace", metadataFormat.getNamespace());

            formats.append(templateHelper.fillTemplate("metadataFormat.template", parameters)).append("\n");
        }

        return templateHelper.fillTopTemplate(this.getClass().getSimpleName(), formats.toString(), "");

    }
}
