package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QOperador is a Querydsl query type for Operador
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOperador extends EntityPathBase<Operador> {

    private static final long serialVersionUID = 1829386182;

    public static final QOperador operador = new QOperador("operador");

    public final StringPath certificado = createString("certificado");

    public final StringPath cif = createString("cif");

    public final DateTimePath<java.util.Date> fechaInscripcion = createDateTime("fechaInscripcion", java.util.Date.class);

    public final NumberPath<Integer> flagCairest = createNumber("flagCairest", Integer.class);

    public final StringPath hashCertificado = createString("hashCertificado");

    public final NumberPath<Long> idOperador = createNumber("idOperador", Long.class);

    public final NumberPath<Long> idOperadorWeb = createNumber("idOperadorWeb", Long.class);

    public final NumberPath<Integer> modeEnabled = createNumber("modeEnabled", Integer.class);

    public final StringPath nombreCorto = createString("nombreCorto");

    public final StringPath razonSocial = createString("razonSocial");

    public final StringPath url = createString("url");

    public QOperador(String variable) {
        super(Operador.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QOperador(Path<? extends Operador> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QOperador(PathMetadata<?> metadata) {
        super(Operador.class, metadata);
    }

}

