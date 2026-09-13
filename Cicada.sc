Cicada : Creature {

    dawn {
        this release: 0.8;
        this add: {
            var trig, sig, pan;
            trig = Dust.kr(LFNoise1.kr(0.3).range(1.5, 5));
            pan = TRand.kr(-0.8, 0.8, trig);
            sig = PlayBuf.ar(2, Cicada.buffer, rate: TRand.kr(0.9, 1.2, trig), trigger: trig, loop: 0);
            sig = sig.asArray.sum * EnvGen.kr(Env.perc(0.005, 0.08), trig);
            Pan2.ar((sig * 8.0).tanh, pan);
        }.play;
    }

    day {
        this release: 0.5;
        this add: {
            var heatSwell, tymbalPulse, sig, pan;
            tymbalPulse = LFTri.ar(48).range(0.2, 1.0);
            heatSwell = SinOsc.kr(0.1).range(0.65, 1.0);
            pan = SinOsc.kr(0.07).range(-0.55, 0.55);
            sig = PlayBuf.ar(2, Cicada.buffer, rate: 1.3, loop: 1);
            sig = sig.asArray.sum * tymbalPulse * heatSwell;
            Pan2.ar((sig * 16.0).tanh, pan);
        }.play;
    }

    dusk {
        this release: 0.5;
        this add: {
            var sig = PlayBuf.ar(buffer.numChannels, Cicada.buffer, rate: 0.75 * BufRateScale.kr(buffer), loop: 1);
            var pulse = LFTri.ar(16).range(0.3, 1.0);
            (sig.asArray.sum * pulse * 12.0).tanh.dup;
        }.play;
    }

    night {
        this release: 1.5;
    }

    danger {
        this release: 0.15;
        this add: {
            var stutter, pitchJitter, sig, pan;
            stutter = LFPulse.ar(LFNoise0.kr(16).range(20, 65), 0, 0.4);
            pitchJitter = LFNoise0.kr(12).range(1.7, 2.5);
            pan = LFNoise1.kr(8).range(-0.95, 0.95);
            sig = PlayBuf.ar(2, Cicada.buffer, rate: pitchJitter, loop: 1);
            sig = sig.asArray.sum * stutter;
            Pan2.ar((sig * 18.0).tanh, pan);
        }.play;
    }
}
