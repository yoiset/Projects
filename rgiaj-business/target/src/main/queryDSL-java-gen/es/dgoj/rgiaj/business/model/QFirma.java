package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QFirma is a Querydsl query type for Firma
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFirma extends EntityPathBase<Firma> {

    private static final long serialVersionUID = 887858161;

    public static final QFirma firma = new QFirma("firma");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final NumberPath<Integer> defecto = createNumber("defecto", Integer.class);

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFirma(String variable) {
        super(Firma.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QFirma(Path<? extends Firma> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QFirma(PathMetadata<?> metadata) {
        super(Firma.class, metadata);
    }

}

