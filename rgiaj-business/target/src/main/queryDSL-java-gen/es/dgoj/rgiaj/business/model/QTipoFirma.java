package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTipoFirma is a Querydsl query type for TipoFirma
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTipoFirma extends EntityPathBase<TipoFirma> {

    private static final long serialVersionUID = -2118743523;

    public static final QTipoFirma tipoFirma = new QTipoFirma("tipoFirma");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final NumberPath<Integer> defecto = createNumber("defecto", Integer.class);

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QTipoFirma(String variable) {
        super(TipoFirma.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QTipoFirma(Path<? extends TipoFirma> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QTipoFirma(PathMetadata<?> metadata) {
        super(TipoFirma.class, metadata);
    }

}

